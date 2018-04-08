package com.yishenghuo.yishenghuo.Prensenter;

import android.util.Log;

import com.yishenghuo.yishenghuo.ui.LoginView;
import com.yishenghuo.yishenghuo.ApiService;
import com.yishenghuo.yishenghuo.bean.UserBean;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LoginPresenter {
    private LoginView mLoginView;
    private Disposable mDisposable;
    //private LoginModel mLoginModel;

    public LoginPresenter(LoginView loginView) {
        this.mLoginView = loginView;
        // mLoginModel = new LoginModelImpl ();
    }

    public void login(String string) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder ().addInterceptor ( new Interceptor () {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request ()
                        .newBuilder ()
                        .addHeader ( "Content-Type", "application/x-www-form-urlencoded" )
                        .addHeader ( "Accept", "text/plain" )
                        .build ();
                return chain.proceed ( request );
            }

        } ).build ();
        MediaType json = MediaType.parse ( "application/json; charset=utf-8" );
        RequestBody requestBody = RequestBody.create ( json, string );
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl ( ApiService.BASE_URL )
                .client ( okHttpClient )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .addConverterFactory ( ScalarsConverterFactory.create () )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();
        // 创建 网络请求接口 的实例
        final ApiService apiservise = retrofit.create ( ApiService.class );
        apiservise.getUser ( requestBody )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer <UserBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        Log.e ( "测试", "onSubscribe" );
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        Log.e ( "测试", "Next" );
                        mLoginView.showLoginResult ( userBean );
                        mLoginView.saveData ( userBean );
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e ( "测试", "onError" );
                    }

                    @Override
                    public void onComplete() {
                        Log.e ( "测试", "Complete" );
                    }
                } );
    }

    public void unSubscription() {
        if (mDisposable != null && !mDisposable.isDisposed ()) {
            mDisposable.dispose ();
        }
    }
}

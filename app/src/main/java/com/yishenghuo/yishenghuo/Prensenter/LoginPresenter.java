package com.yishenghuo.yishenghuo.Prensenter;

import android.util.Log;

import com.yishenghuo.yishenghuo.DataManager;
import com.yishenghuo.yishenghuo.base.BasePresenter;
import com.yishenghuo.yishenghuo.ui.LoginView;
import com.yishenghuo.yishenghuo.Model.bean.UserBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class LoginPresenter extends BasePresenter{
    private LoginView mLoginView;
    private Disposable mDisposable;
    //private LoginModel mLoginModel;

    public LoginPresenter(LoginView loginView) {
        this.mLoginView = loginView;
        // mLoginModel = new LoginModelImpl ();
    }

    public void login(RequestBody loginBody) {
        DataManager.getInstance ()
                .getApiService ()
                .getUser ( loginBody )
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
                        Log.e ( "测试", "Complete " + mDisposable.isDisposed () );
                    }
                } );
    }

    @Override
    public void unSubscription() {
        super.unSubscription ();
    }
}

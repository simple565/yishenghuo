package com.yishenghuo.yishenghuo.Prensenter;

import android.util.Log;

import com.yishenghuo.yishenghuo.DataManager;
import com.yishenghuo.yishenghuo.Model.bean.UserBean;
import com.yishenghuo.yishenghuo.base.BaseObserver;
import com.yishenghuo.yishenghuo.base.BasePresenter;
import com.yishenghuo.yishenghuo.base.BaseView;
import com.yishenghuo.yishenghuo.ui.RegisterView;
import com.yishenghuo.yishenghuo.util.RequestBodyUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter extends BasePresenter {
    private RegisterView mRegisterView;
    private Disposable mDisposable;

    public RegisterPresenter(RegisterView registerView) {
        this.mRegisterView = registerView;
    }

    public void getVerifyCode(String phone) {
        DataManager.getInstance ()
                .getApiService ()
                .getVerifyCode ( RequestBodyUtil.getPhone ( phone ) )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer <UserBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        mRegisterView.startCountDown ();
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        mRegisterView.showResult ( userBean );
                        Log.e ( "测试", "onNext " + userBean.getCode () );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e ( "测试", "onError" );
                    }

                    @Override
                    public void onComplete() {
                        Log.e ( "测试", "onNext " + mDisposable.isDisposed () );
                    }
                } );
    }

    public void register(String phone, String code, String password) {
        DataManager.getInstance ()
                .getApiService ()
                .register ( RequestBodyUtil.getVerifyBody ( phone, code ) )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new BaseObserver <UserBean> () {
                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onSuccess(UserBean userBean) {
                        mRegisterView.showResult ( userBean );
                        mRegisterView.saveData ( userBean );
                    }

                    @Override
                    public void onFail(Throwable e) {

                    }
                } );
    }

    @Override
    public void unSubscription() {
        super.unSubscription ();
    }
}

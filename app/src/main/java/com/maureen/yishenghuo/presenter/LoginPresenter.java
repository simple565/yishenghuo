package com.maureen.yishenghuo.presenter;

import android.util.Log;

import com.maureen.yishenghuo.contract.LoginContract;
import com.maureen.yishenghuo.DataManager;
import com.maureen.yishenghuo.bean.UserBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class LoginPresenter {
    private String TAG = LoginPresenter.class.getSimpleName();
    private LoginContract mLoginContract;
    private Disposable mDisposable;
    //private LoginModel mLoginModel;

    public LoginPresenter(LoginContract loginContract) {
        this.mLoginContract = loginContract;
        // mLoginModel = new LoginModelImpl ();
    }

    public void login(RequestBody loginBody) {
        DataManager.getInstance()
                .getApiService()
                .getUser(loginBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        Log.e(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        Log.e(TAG, "Next");
                        mLoginContract.showLoginResult(userBean);
                        mLoginContract.saveData(userBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "Complete " + mDisposable.isDisposed());
                    }
                });
    }
}

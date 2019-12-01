package com.maureen.yishenghuo.presenter;

import android.util.Log;

import com.maureen.yishenghuo.contract.RegisterContract;
import com.maureen.yishenghuo.DataManager;
import com.maureen.yishenghuo.base.BaseObserver;
import com.maureen.yishenghuo.bean.UserBean;
import com.maureen.yishenghuo.util.RequestBodyUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter {
    private RegisterContract mRegisterContract;
    private Disposable mDisposable;

    public RegisterPresenter(RegisterContract registerContract) {
        this.mRegisterContract = registerContract;
    }

    public void getVerifyCode(String phone) {
        DataManager.getInstance()
                .getApiService()
                .getVerifyCode(RequestBodyUtil.getPhone(phone))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        mRegisterContract.startCountDown();
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        mRegisterContract.showResult(userBean);
                        Log.e("测试", "onNext " + userBean.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("测试", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("测试", "onNext " + mDisposable.isDisposed());
                    }
                });
    }

    public void register(String phone, String code, String password) {
        DataManager.getInstance()
                .getApiService()
                .register(RequestBodyUtil.getVerifyBody(phone, code))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<UserBean>() {
                    @Override
                    public void onLoading() {

                    }

                    @Override
                    public void onSuccess(UserBean userBean) {
                        mRegisterContract.showResult(userBean);
                        mRegisterContract.saveData(userBean);
                    }

                    @Override
                    public void onFail(Throwable e) {

                    }
                });
    }

}

package com.yishenghuo.yishenghuo.base;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer <T> {
    private Disposable mDisposable;

    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(T t) {
        onSuccess ( t );
    }

    @Override
    public void onError(Throwable e) {
        onFail ( e );
        mDisposable.dispose ();
    }

    @Override
    public void onComplete() {
        mDisposable.dispose ();
        Log.e ( "测试", "Complete " + mDisposable.isDisposed () );
    }

    public abstract void onLoading();

    public abstract void onSuccess(T t);

    public abstract void onFail(Throwable e);
}

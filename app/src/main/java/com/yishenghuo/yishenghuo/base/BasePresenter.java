package com.yishenghuo.yishenghuo.base;

import android.view.View;

import io.reactivex.disposables.Disposable;

public class BasePresenter{
    private Disposable mDisposable;

    public void unSubscription() {
        if (mDisposable != null && !mDisposable.isDisposed ()) {
            mDisposable.dispose ();
        }
    }
}

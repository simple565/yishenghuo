package com.yishenghuo.yishenghuo.base;

import io.reactivex.disposables.Disposable;

public class BaseModel {
    private Disposable mDisposable;

    public void unSubscribe() {
        if (mDisposable != null && !mDisposable.isDisposed ()) {
            mDisposable.dispose ();
        }
    }
}

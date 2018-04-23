package com.yishenghuo.yishenghuo.Model;

import android.util.Log;

import com.yishenghuo.yishenghuo.ApiService;
import com.yishenghuo.yishenghuo.DataManager;
import com.yishenghuo.yishenghuo.base.BaseModel;
import com.yishenghuo.yishenghuo.DataCallBack;
import com.yishenghuo.yishenghuo.Model.bean.NewsBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsModel extends BaseModel {
    private Disposable mDisposable;

    public void getNews(String key, final DataCallBack <NewsBean> newsBeanDataCallBack) {
        DataManager.getInstance ().changeUrl ( ApiService.NEWS_BASE_URL );
        DataManager.getInstance ().getApiService ().getNewsInfo ( "头条", key )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer <NewsBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        Log.e ( "测试", "onSubscribe " + mDisposable.isDisposed () );
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        newsBeanDataCallBack.onSuccess ( newsBean );
                        Log.e ( "测试", "onNext " + mDisposable.isDisposed () );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e ( "测试", "onError " + mDisposable.isDisposed () );
                        mDisposable.dispose ();
                    }

                    @Override
                    public void onComplete() {
                        mDisposable.dispose ();
                        Log.e ( "测试", "onComplete " + mDisposable.isDisposed () );
                    }
                } );
    }

    @Override
    public void unSubscribe() {
        super.unSubscribe ();
    }
}

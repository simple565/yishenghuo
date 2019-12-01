package com.maureen.yishenghuo.neighborhood;

import android.util.Log;

import com.maureen.yishenghuo.DataCallBack;
import com.maureen.yishenghuo.DataManager;
import com.maureen.yishenghuo.base.BaseEntity;
import com.maureen.yishenghuo.base.BaseModel;
import com.maureen.yishenghuo.bean.NeighborCircleEntity;
import com.maureen.yishenghuo.util.RxExceptionUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @author Lian
 * @create 2018/4/24
 * @Describe 邻居圈总览
 */
public class NeighborCircleModel extends BaseModel {
    private Disposable mDisposable;

    public void getDynamicData(int user_id, final DataCallBack<NeighborCircleEntity> entityDataCallBack) {
        DataManager.getInstance().getApiService()
                .getNeighborDynamic("8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NeighborCircleEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(NeighborCircleEntity entity) {
                        entityDataCallBack.onSuccess(entity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDisposable.dispose();
                        Log.e("测试", "错误:" + RxExceptionUtil.exceptionHandler(e));
                    }

                    @Override
                    public void onComplete() {
                        mDisposable.dispose();
                    }
                });
    }

    public void getDynamicDetal(int user_id) {
        DataManager.getInstance().getApiService()
                .getDynamicDetal(user_id + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<com.maureen.yishenghuo.bean.NeighborCircleEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(com.maureen.yishenghuo.bean.NeighborCircleEntity entity) {
                        Log.e("测试", "数据：" + entity.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("测试", "错误:" + RxExceptionUtil.exceptionHandler(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getNeighborDynamic(int user_id) {
        DataManager.getInstance().getApiService()
                .getFriendDynamic("8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<com.maureen.yishenghuo.bean.NeighborCircleEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(com.maureen.yishenghuo.bean.NeighborCircleEntity entity) {
                        Log.e("测试", "数据：" + entity.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDisposable.dispose();
                        Log.e("测试", "错误:" + RxExceptionUtil.exceptionHandler(e));
                    }

                    @Override
                    public void onComplete() {
                        mDisposable.dispose();
                    }
                });
    }

    public void addDynamic(RequestBody body) {
        DataManager.getInstance().getApiService()
                .addDynamic(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity entity) {
                        Log.e("测试", "数据：" + entity.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("测试", "错误:" + RxExceptionUtil.exceptionHandler(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addComment(RequestBody body) {
        DataManager.getInstance().getApiService()
                .addComment(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity entity) {
                        Log.e("测试", "数据：" + entity.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("测试", "错误:" + RxExceptionUtil.exceptionHandler(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void unSubscribe() {
        super.unSubscribe();
    }
}

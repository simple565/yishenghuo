package com.yishenghuo.yishenghuo.Model;

import android.util.Log;

import com.yishenghuo.yishenghuo.ApiService;
import com.yishenghuo.yishenghuo.DataCallBack;
import com.yishenghuo.yishenghuo.DataManager;
import com.yishenghuo.yishenghuo.Model.bean.HealthEntity;
import com.yishenghuo.yishenghuo.base.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Lian
 * @create 2018/4/22
 * @Describe 健康知识获取
 */
public class HealthModel extends BaseModel {
    private Disposable mDisposable;

    public void getHealthyEntity(final DataCallBack <HealthEntity> healthyEntityDataCallBack) {
        DataManager.getInstance ().changeUrl ( ApiService.HEALTHY_BASE_URL );
        DataManager.getInstance ()
                .getApiService ()
                .getHealthyInfo ( "432d83c7ae64d32b7b17fc812ae24342", 10 )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer <HealthEntity> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(HealthEntity healthEntity) {
                        Log.e ( "测试", healthEntity.getCode ()+"");
                        healthyEntityDataCallBack.onSuccess ( healthEntity );
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDisposable.dispose ();
                    }

                    @Override
                    public void onComplete() {
                        Log.e ( "测试", mDisposable.isDisposed () +"");
                    }
                } );
    }

    @Override
    public void unSubscribe() {
        super.unSubscribe ();
    }
}

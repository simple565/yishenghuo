package com.yishenghuo.yishenghuo.Model;

import com.yishenghuo.yishenghuo.ApiService;
import com.yishenghuo.yishenghuo.DataCallBack;
import com.yishenghuo.yishenghuo.DataManager;
import com.yishenghuo.yishenghuo.Model.bean.IllegalityEntity;
import com.yishenghuo.yishenghuo.base.BaseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @author Lian
 * @create 2018/4/23
 * @Describe 违章数据请求
 */
public class IllegalityModel extends BaseModel {
    private Disposable mDisposable;

    public void getData(RequestBody body, final DataCallBack <IllegalityEntity> entityDataCallBack) {
        DataManager.getInstance ().changeUrl ( ApiService.ILLEGALIT_BASE_URL );
        DataManager.getInstance ()
                .getApiService ()
                .getIllegalitInfo ( body )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer <IllegalityEntity> () {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(IllegalityEntity illegalityEntity) {
                        entityDataCallBack.onSuccess ( illegalityEntity );
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );
    }

    @Override
    public void unSubscribe() {
        super.unSubscribe ();
    }
}

package com.yishenghuo.yishenghuo.Neighborhood;

import com.yishenghuo.yishenghuo.DataCallBack;
import com.yishenghuo.yishenghuo.Model.HealthModel;
import com.yishenghuo.yishenghuo.Model.NewsModel;
import com.yishenghuo.yishenghuo.Model.bean.HealthEntity;
import com.yishenghuo.yishenghuo.base.BasePresenter;
import com.yishenghuo.yishenghuo.base.BaseView;

/**
 * @author Lian
 * @create 2018/4/22
 * @Describe
 */
public class HealthPresenter extends BasePresenter implements DataCallBack<HealthEntity> {
    private HealthModel mHealthModel;
    private BaseView<HealthEntity> mBaseView;

    public HealthPresenter(BaseView<HealthEntity> mBaseView){
        this.mBaseView=mBaseView;
        this.mHealthModel=new HealthModel ();
    }
    public void showHealthInfo(){
        mHealthModel.getHealthyEntity ( this );
    }

    @Override
    public void onSuccess(HealthEntity data) {
        mBaseView.showResult ( data );
    }
}

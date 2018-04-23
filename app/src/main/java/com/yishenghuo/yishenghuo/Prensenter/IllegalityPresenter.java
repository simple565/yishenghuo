package com.yishenghuo.yishenghuo.Prensenter;

import com.yishenghuo.yishenghuo.DataCallBack;
import com.yishenghuo.yishenghuo.Model.IllegalityModel;
import com.yishenghuo.yishenghuo.Model.bean.IllegalityEntity;
import com.yishenghuo.yishenghuo.base.BasePresenter;
import com.yishenghuo.yishenghuo.base.BaseView;

/**
 * @author Lian
 * @create 2018/4/23
 * @Describe
 */
public class IllegalityPresenter implements DataCallBack <IllegalityEntity> {
    private BaseView <IllegalityEntity> mBaseView;
    private IllegalityModel mIllegalityModel;

    public IllegalityPresenter(BaseView <IllegalityEntity> baseView) {
        this.mBaseView = baseView;
        this.mIllegalityModel = new IllegalityModel ();
    }

    private void showResult() {
        //mIllegalityModel.getData ( this );
    }

    @Override
    public void onSuccess(IllegalityEntity data) {
        mBaseView.showResult ( data );
    }
}

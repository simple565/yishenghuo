package com.yishenghuo.yishenghuo.ServiceSupport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yishenghuo.yishenghuo.Model.bean.IllegalityEntity;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.base.BaseView;

public class IllegalityActivity extends AppCompatActivity implements BaseView<IllegalityEntity>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_illegality );
    }

    @Override
    public void showResult(IllegalityEntity illegalityEntity) {

    }

    @Override
    public void saveData(IllegalityEntity illegalityEntity) {

    }
}

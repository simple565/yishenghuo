package com.yishenghuo.yishenghuo.ServiceSupport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yishenghuo.yishenghuo.Model.bean.IllegalityEntity;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.base.BaseView;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class IllegalityActivity extends AppCompatActivity implements BaseView<IllegalityEntity>{

    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_illegality );
        iniView();
    }

    public void iniView() {
        mTitleBar = findViewById(R.id.illegality_titlebar);
        mTitleBar.setText("违章查询");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }

    @Override
    public void showResult(IllegalityEntity illegalityEntity) {

    }

    @Override
    public void saveData(IllegalityEntity illegalityEntity) {

    }
}

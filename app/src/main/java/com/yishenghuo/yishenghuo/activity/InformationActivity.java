package com.yishenghuo.yishenghuo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class InformationActivity extends AppCompatActivity {

    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.information_titlebar);
        mTitleBar.setText("我的资料");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }
}

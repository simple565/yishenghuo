package com.yishenghuo.yishenghuo.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.weiget.TitleBar;

public class ElectricActivity extends AppCompatActivity {
    private TitleBar mTitleBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.electric_titlebar);
        mTitleBar.setText("电费缴交");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }


}
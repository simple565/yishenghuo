package com.yishenghuo.yishenghuo.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class GasActivity extends AppCompatActivity {
    private TitleBar mTitleBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas);
        iniView();

    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.gas_titlebar);
        mTitleBar.setText("燃气缴费");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }


}
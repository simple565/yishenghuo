package com.maureen.yishenghuo.activity;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

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
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
package com.maureen.yishenghuo.activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

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
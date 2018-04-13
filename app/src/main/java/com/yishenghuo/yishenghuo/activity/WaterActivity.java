package com.yishenghuo.yishenghuo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.weiget.TitleBar;
//水电费缴交
public class WaterActivity extends AppCompatActivity {
    private TitleBar mTitleBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        iniView();
    }


    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.water_titlebar);
        mTitleBar.setText("水费缴交");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }


}
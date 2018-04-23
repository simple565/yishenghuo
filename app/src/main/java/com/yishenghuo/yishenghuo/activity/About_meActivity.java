package com.yishenghuo.yishenghuo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class About_meActivity extends AppCompatActivity {

    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.about_us_titlebar);
        mTitleBar.setText("关于我们");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }
}

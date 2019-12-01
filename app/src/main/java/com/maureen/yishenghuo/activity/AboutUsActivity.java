package com.maureen.yishenghuo.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        iniView();
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.about_us_titlebar);
        mTitleBar.setText("关于我们");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

package com.maureen.yishenghuo.servicesupport;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

public class GuessComeActivity extends AppCompatActivity {

    private TitleBar mTitleBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.service_titlebar);
        mTitleBar.setText("访客授权");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }
}

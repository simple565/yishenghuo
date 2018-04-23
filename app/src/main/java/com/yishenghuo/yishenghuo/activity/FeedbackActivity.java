package com.yishenghuo.yishenghuo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class FeedbackActivity extends AppCompatActivity {

    private  TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.feedback_titlebar);
        mTitleBar.setText("意见反馈");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }
}

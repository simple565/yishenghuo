package com.maureen.yishenghuo.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

public class FeedbackActivity extends AppCompatActivity {

    private TitleBar mTitleBar;

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

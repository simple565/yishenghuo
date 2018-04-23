package com.yishenghuo.yishenghuo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class Change_passwordActivity extends AppCompatActivity {

    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.change_password_titlebar);
        mTitleBar.setText("修改密码");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }
}

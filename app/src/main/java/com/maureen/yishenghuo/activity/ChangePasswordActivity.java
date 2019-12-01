package com.maureen.yishenghuo.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

public class ChangePasswordActivity extends AppCompatActivity {

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

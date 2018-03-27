package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

//登录
public class LoginActivity extends AppCompatActivity {
    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniView();
    }

    private void iniView() {

        mTitleBar = (TitleBar) findViewById(R.id.login_titlebar);
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setText("登录");
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//结束
            }
        });
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}

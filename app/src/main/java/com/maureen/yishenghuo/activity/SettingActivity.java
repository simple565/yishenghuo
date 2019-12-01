package com.maureen.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        iniView();
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.setting_titlebar);
        mTitleBar.setText("设置");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, Message.class));
            }
        });
        RelativeLayout rl_community = findViewById(R.id.setting_layout_community);
        rl_community.setOnClickListener(this);
        Button btn_quit = findViewById(R.id.setting_btn_quit);
        btn_quit.setOnClickListener(this);
        ImageView iv_favicon = findViewById(R.id.setting_iv_favicon);
        iv_favicon.setOnClickListener(this);
        RelativeLayout changePassword = findViewById(R.id.setting_layout_changePassword);
        changePassword.setOnClickListener(this);
        RelativeLayout layout_changePhone = findViewById(R.id.setting_layout_changePhone);
        layout_changePhone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.setting_btn_quit:
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                finish();
                break;
            case R.id.setting_layout_community:
                //                startActivity ( new Intent ( this, MapActivity.class ) );
                break;
            case R.id.setting_iv_favicon:
                startActivity(new Intent(this, InformationActivity.class));
                break;
            case R.id.setting_layout_changePassword:
                startActivity(new Intent(this, ChangePasswordActivity.class));
                break;
            case R.id.setting_layout_changePhone:
                startActivity(new Intent(this, BindingPhoneActivity.class));
                break;
            default:
                break;

        }
    }
}


package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yishenghuo.yishenghuo.Map.MapActivity;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class SettingActivity extends AppCompatActivity {

    private TextView mtv_xiaoqu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_setting );
        iniView ();

        mtv_xiaoqu = (TextView) findViewById(R.id.water_the_next);

        mtv_xiaoqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById ( R.id.setting_titlebar );
        mTitleBar.setText ( "设置" );
        mTitleBar.setLeftButton ( R.drawable.ic_arrow_left );
        mTitleBar.setLeftButtonClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                finish ();
            }
        } );
        mTitleBar.setRightButtonClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( SettingActivity.this, Message.class ) );
            }
        } );
        Button btn_quit = findViewById ( R.id.setting_btn_quit );
        btn_quit.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( SettingActivity.this, LoginActivity.class ) );
                finish ();
            }
        } );

    }
}


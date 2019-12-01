package com.maureen.yishenghuo.servicesupport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.neighborhood.MessageActivity;
import com.maureen.yishenghuo.ui.TitleBar;

public class HouseKeepingActivity extends AppCompatActivity {

    private TitleBar mTitleBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_keeping);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.house_keeping_titlebar);
        mTitleBar.setText("家政服务");
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
                startActivity(new Intent(HouseKeepingActivity.this, MessageActivity.class));
            }
        });

    }
}

package com.maureen.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.neighborhood.MessageActivity;
import com.maureen.yishenghuo.ui.TitleBar;

//物业缴费
public class PropertyActivity extends AppCompatActivity {
    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        iniView();
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.property_titlebar);
        mTitleBar.setText("物业缴费");
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
                Intent intent = new Intent(PropertyActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
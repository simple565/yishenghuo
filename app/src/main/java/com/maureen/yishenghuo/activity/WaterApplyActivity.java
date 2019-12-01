package com.maureen.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

public class WaterApplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_apply);
        iniView();


    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.water_apply_titlebar);
        mTitleBar.setText("新增缴费用户");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button water_next = (Button) findViewById(R.id.water_the_next);
        water_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaterApplyActivity.this, WaterActivity.class);
                startActivity(intent);
            }
        });
    }
}

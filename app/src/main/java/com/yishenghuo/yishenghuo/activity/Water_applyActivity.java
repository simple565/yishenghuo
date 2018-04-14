package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class Water_applyActivity extends AppCompatActivity {

    private TitleBar mTitleBar;
    private Button  water_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_apply);
        iniView();

        water_next = (Button)findViewById(R.id.water_the_next);

        water_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Water_applyActivity.this,WaterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.water_apply_titlebar);
        mTitleBar.setText("新增缴费用户");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }
}

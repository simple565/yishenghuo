package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class PropertyApplyActivity extends AppCompatActivity {

    private TitleBar mTitleBar;
    private Button property_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propery_apply);

        iniView();

        property_next = (Button)findViewById(R.id.property_the_next);

        property_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PropertyApplyActivity.this,PropertyActivity.class);
                startActivity(intent);
            }
        });
    }

    public void iniView() {
        mTitleBar = (TitleBar) findViewById(R.id.property_apply_titlebar);
        mTitleBar.setText("新增缴费用户");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

    }
}

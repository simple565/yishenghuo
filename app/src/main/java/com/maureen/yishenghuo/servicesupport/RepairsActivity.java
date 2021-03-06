package com.maureen.yishenghuo.servicesupport;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.ui.TitleBar;

public class RepairsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        iniView();
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.repair_titlebar);
        mTitleBar.setText("报修");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

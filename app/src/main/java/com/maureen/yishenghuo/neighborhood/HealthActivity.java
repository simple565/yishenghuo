package com.maureen.yishenghuo.neighborhood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.adapter.HealthAdapter;
import com.maureen.yishenghuo.bean.HealthEntity;
import com.maureen.yishenghuo.ui.TitleBar;

public class HealthActivity extends AppCompatActivity {
    private HealthPresenter mHealthPresenter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        iniView();
        iniData();
    }

    private void iniData() {
        //mHealthPresenter = new HealthPresenter ( this );
        //mHealthPresenter.showHealthInfo ();
    }

    private void iniView() {
        TitleBar mTitleBar = findViewById(R.id.health_titleBar);
        mTitleBar.setText("健康知识");
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
                startActivity(new Intent(HealthActivity.this, MessageActivity.class));
            }
        });
        mListView = findViewById(R.id.health_list);
    }


    public void showResult(HealthEntity healthEntity) {
        mListView.setAdapter(new HealthAdapter(this, healthEntity.getNewslist()));
    }

    public void saveData(HealthEntity healthEntity) {

    }
}

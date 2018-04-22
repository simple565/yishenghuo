package com.yishenghuo.yishenghuo.Neighborhood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.yishenghuo.yishenghuo.Model.bean.HealthEntity;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.adapter.HealthAdapter;
import com.yishenghuo.yishenghuo.base.BaseView;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class HealthActivity extends AppCompatActivity implements BaseView <HealthEntity> {
    private HealthPresenter mHealthPresenter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_health );
        iniView ();
        iniData ();
    }

    private void iniData() {
        mHealthPresenter = new HealthPresenter ( this );
        mHealthPresenter.showHealthInfo ();
    }

    private void iniView() {
        TitleBar mTitleBar = findViewById ( R.id.health_titleBar );
        mTitleBar.setHomeIcon ();
        mTitleBar.setLeftButtonClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                finish ();
            }
        } );
        mTitleBar.setRightButtonClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( HealthActivity.this, MessageActivity.class ) );
            }
        } );
        mListView = findViewById ( R.id.health_list );
    }

    @Override
    public void showResult(HealthEntity healthEntity) {
        // Log.e ( "测试", "数据" );
        mListView.setAdapter ( new HealthAdapter ( this,healthEntity.getNewslist () ) );
    }

    @Override
    public void saveData(HealthEntity healthEntity) {

    }
}

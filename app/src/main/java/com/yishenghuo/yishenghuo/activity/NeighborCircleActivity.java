package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.weiget.TitleBar;

public class NeighborCircleActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbor_circle);
        iniView();
    }

    private void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.neighbor_circle_titlebar);
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.setText("邻居圈");
        mTitleBar.setRightButton(R.drawable.ic_camera);
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeighborCircleActivity.this, MessageActivity.class));
            }
        });
        mRelativeLayout = (RelativeLayout) findViewById(R.id.neighbor_circle_rl);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.neighbor_circle_swipe);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRelativeLayout.setVisibility(View.VISIBLE);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}

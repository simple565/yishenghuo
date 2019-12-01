package com.maureen.yishenghuo.neighborhood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.adapter.NeighborCircleAdapter;
import com.maureen.yishenghuo.bean.NeighborCircleEntity;
import com.maureen.yishenghuo.ui.TitleBar;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 邻居圈
 * @Author Lianml
 */
public class NeighborCircleActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RelativeLayout mRelativeLayout;
    private NeighborCirclePresenter mNeighborCirclePresenter;
    private ListView mDynamicList;

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
        //mNeighborCirclePresenter = new NeighborCirclePresenter ( this );
        mDynamicList = findViewById(R.id.neighbor_circle_list);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.neighbor_circle_rl);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.neighbor_circle_swipe);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRelativeLayout.setVisibility(View.VISIBLE);
                mSwipeRefreshLayout.setRefreshing(false);
                //mNeighborCirclePresenter.showDynamic ();
            }
        });

    }


    public void showResult(NeighborCircleEntity entity) {
        List<com.maureen.yishenghuo.bean.NeighborCircleEntity> list = new ArrayList<>();
        Log.e("测试", "数据2：" + entity.getData().get(0).getContent().getNickname());
        mDynamicList.setAdapter(new NeighborCircleAdapter(this, entity.getData()));
    }


    public void saveData(NeighborCircleEntity entity) {

    }
}

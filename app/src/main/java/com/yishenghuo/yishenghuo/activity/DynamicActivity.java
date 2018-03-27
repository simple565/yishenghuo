package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.adapter.DynamicAdapter;
import com.yishenghuo.yishenghuo.bean.DynamicItemBean;
import com.yishenghuo.yishenghuo.ui.TitleBar;

import java.util.List;

public class DynamicActivity extends AppCompatActivity {
    private ListView mListView;
    private List<DynamicItemBean> mDynamicItemBeanList;
    private DynamicAdapter mDynamicAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        iniView();
    }

    //初始从服务器获取数据  异步耗时操作
    private void iniData() {

    }

    private void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById(R.id.dynamic_titlebar);
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DynamicActivity.this, MessageActivity.class));
            }
        });
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mListView = findViewById(R.id.dynamic_list);
        mListView.setAdapter(mDynamicAdapter);

    }
}

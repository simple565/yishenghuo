package com.maureen.yishenghuo.neighborhood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.adapter.DynamicAdapter;
import com.maureen.yishenghuo.bean.DynamicItemBean;
import com.maureen.yishenghuo.ui.TitleBar;

import java.util.List;

/**
 * author Lian
 * Description 小区动态
 */

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

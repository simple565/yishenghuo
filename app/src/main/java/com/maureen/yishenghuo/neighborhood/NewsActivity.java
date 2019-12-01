package com.maureen.yishenghuo.neighborhood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.adapter.NewsAdaptor;
import com.maureen.yishenghuo.bean.NewsBean;
import com.maureen.yishenghuo.ui.TitleBar;

public class NewsActivity extends AppCompatActivity {
    private Context mContext;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        iniView();
        getNews();
    }

    private void iniView() {

        TitleBar mTitleBar = (TitleBar) findViewById(R.id.news_titlebar);
        mTitleBar.setText("时事新闻");
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewsActivity.this, MessageActivity.class));
            }
        });
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
                startActivity(new Intent(NewsActivity.this, Message.class));
            }
        });

        mListView = (ListView) findViewById(R.id.news_list);
    }

    /**
     * 新闻数据请求,耗时操作
     */
    private void getNews() {
        //       NewsPresenter newsPresenter=new NewsPresenter ( this );
        //       newsPresenter.showNews ();
    }


    public void showResult(NewsBean newsBean) {
        mListView.setAdapter(new NewsAdaptor(this, newsBean.getResult().getList()));
    }
}

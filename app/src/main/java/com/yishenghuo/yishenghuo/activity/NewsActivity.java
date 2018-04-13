package com.yishenghuo.yishenghuo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.yishenghuo.yishenghuo.ApiService;
import com.yishenghuo.yishenghuo.DataManager;
import com.yishenghuo.yishenghuo.Model.bean.NewsBean;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.weiget.TitleBar;
import com.yishenghuo.yishenghuo.adapter.NewsAdaptor;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsActivity extends AppCompatActivity {
    private TitleBar mTitleBar;
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

        mTitleBar = (TitleBar) findViewById(R.id.news_titlebar);
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
        //新闻API密钥
        final String API_KEY = "44239bc79ecdc150";
        DataManager.getInstance ().changeUrl ( ApiService.NEWS_BASE_URL );
        DataManager.getInstance ().getApiService ()
                .getNewsInfo ( "头条",API_KEY )
                .subscribeOn ( Schedulers.io () )
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer <NewsBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );
    }

    //显示新闻数据
    private void setNews(NewsBean newsBean) {
        mListView.setAdapter(new NewsAdaptor(this, newsBean.getResult().getList()));
    }
}

package com.yishenghuo.yishenghuo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.yishenghuo.yishenghuo.bean.NewsBean;
import com.yishenghuo.yishenghuo.NewsInf;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;
import com.yishenghuo.yishenghuo.adapter.NewsAdaptor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        //指定返回数量
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsInf.BASE_URL) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 创建 网络请求接口 的实例
        final NewsInf newsInf = retrofit.create(NewsInf.class);
        //发送请求 进行封装
        Call<NewsBean> call = newsInf.getNewsInfo("头条", API_KEY);//0,10,
        //发送网络请求(异步)
        call.enqueue(new Callback<NewsBean>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                // 步骤7：处理返回的数据结果
                NewsBean newsBean = response.body();
                if (response.body() != null) {
                    setNews(newsBean);

                }

            }

            //请求失败时回调
            @Override
            public void onFailure(Call<NewsBean> call, Throwable throwable) {
                Log.e("test", "连接失败");


            }
        });
    }

    //显示新闻数据
    private void setNews(NewsBean newsBean) {
        mListView.setAdapter(new NewsAdaptor(this, newsBean.getResult().getList()));
    }
}

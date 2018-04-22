package com.yishenghuo.yishenghuo.Neighborhood;

import com.yishenghuo.yishenghuo.ApiService;
import com.yishenghuo.yishenghuo.DataCallBack;
import com.yishenghuo.yishenghuo.Model.NewsModel;
import com.yishenghuo.yishenghuo.Model.bean.NewsBean;
import com.yishenghuo.yishenghuo.NewsView;
import com.yishenghuo.yishenghuo.base.BaseView;

public class NewsPresenter implements DataCallBack<NewsBean>{
    private BaseView <NewsBean> mBaseView;
    private NewsModel mNewsModel;

    public NewsPresenter(BaseView <NewsBean> baseView) {
        this.mNewsModel = new NewsModel ();
        this.mBaseView = baseView;
    }

    public void showNews() {
        mNewsModel.getNews ( ApiService.NEWS_BASE_URL,this );
    }


    @Override
    public void onSuccess(NewsBean data) {
        mBaseView.showResult ( data );
    }
}

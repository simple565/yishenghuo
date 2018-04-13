package com.yishenghuo.yishenghuo.Prensenter;

import com.yishenghuo.yishenghuo.Model.NewsModel;
import com.yishenghuo.yishenghuo.NewsView;

public class NewsPresenter {
    private NewsView mNewsView;
    private NewsModel mNewsModel;

    public NewsPresenter(NewsView newsView) {
        this.mNewsModel = new NewsModel ();
        this.mNewsView = newsView;
    }

    public void getNews(){

    }



}

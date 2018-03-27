package com.yishenghuo.yishenghuo;

import com.yishenghuo.yishenghuo.bean.NewsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lian on 2018/2/16.
 */

public interface NewsInf {
    String BASE_URL = "http://api.jisuapi.com/news/";
    @GET("get?")
    Call<NewsBean> getNewsInfo(@Query("channel") String channel,@Query("appkey") String key);
}

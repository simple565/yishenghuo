package com.yishenghuo.yishenghuo;

import com.yishenghuo.yishenghuo.Model.bean.HealthEntity;
import com.yishenghuo.yishenghuo.Model.bean.IllegalityEntity;
import com.yishenghuo.yishenghuo.Model.bean.NewsBean;
import com.yishenghuo.yishenghuo.Model.bean.UserBean;
import com.yishenghuo.yishenghuo.Model.bean.WeatherBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 接口集合
 */
public interface ApiService {

    String BASE_URL = "http://123.207.18.66:8000/api/";
    String NEWS_BASE_URL = "http://api.jisuapi.com/news/";
    String ILLEGALIT_BASE_URL = "http://api.jisuapi.com/illegal/";
    String WEATHER_BASE_URL = "https://free-api.heweather.com/v5/";
    String HEALTHY_BASE_URL = "http://api.tianapi.com/";

    @GET("get?")
    Observable <NewsBean> getNewsInfo(@Query("channel") String channel, @Query("appkey") String key);

    @GET("weather?")
    Observable <WeatherBean> getWeatherInfo(@Query("city") String city, @Query("key") String key);

    @GET("health/?")
    Observable <HealthEntity> getHealthyInfo(@Query("key") String key, @Query("num") int num);

    @POST("query")
    Observable <IllegalityEntity> getIllegalitInfo(@Body RequestBody body);

    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("login_page")
    Observable <UserBean> getUser(@Body RequestBody body);//application/json; charset=utf-8

    //获取验证码
    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("register")
    Observable <UserBean> getVerifyCode(@Body RequestBody body);

    //匹配手机和验证码
    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("register_verify_code")
    Observable <UserBean> register(@Body RequestBody body);

    //设置用户名和密码 。
    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("register_setpasswd")
    Observable <UserBean> setPassword(@Body RequestBody body);

    //朋友圈总览
    @GET("moment_view")
    Observable <String> getNeighborDynamic(@Query("user_id") String user_id);

    //获取朋友或自己的全部动态
    @GET("moment_specific_friend")
    Observable <String> getFriendDynamic(@Query("user_id") String user_id);

    //获取动态详细信息
    @GET("moment_specific_content")
    Observable <String> getDynamicDetal(@Query("user_id") String user_id);

    //发布动态
    @POST("moment_release")
    Observable <String> setDynamic(@Body RequestBody content);

    //发表评论
    @POST("moment_comment")
    Observable <String> setComment(@Body RequestBody content);
}

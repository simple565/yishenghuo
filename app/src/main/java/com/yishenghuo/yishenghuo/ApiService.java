package com.yishenghuo.yishenghuo;

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
 * 天气查询接口
 */
public interface ApiService {

    String BASE_URL = "http://123.207.18.66:8000/api/";
    String NEWS_BASE_URL = "http://api.jisuapi.com/news/";
    String WEATHER_BASE_URL = "https://free-api.heweather.com/v5/";

    @GET("get?")
    Observable <NewsBean> getNewsInfo(@Query("channel") String channel, @Query("appkey") String key);

    @GET("weather?")
    Observable <WeatherBean> getWeatherInfo(@Query("city") String city, @Query("key") String key);

    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("login_page")
    Observable <UserBean> getUser(@Body RequestBody body);//application/json; charset=utf-8

    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("register")
    Observable <UserBean> getVerifyCode(@Body RequestBody body);

    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("register_verify_code")
    Observable <UserBean> register(@Body RequestBody body);

    @Headers({"Content-Type:application/x-www-form-urlencoded", "Accept:text/plain"})
    @POST("register_setpasswd")
    Observable <UserBean> setPassword(@Body RequestBody body);
}

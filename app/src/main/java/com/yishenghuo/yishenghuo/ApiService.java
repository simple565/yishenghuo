package com.yishenghuo.yishenghuo;

import com.yishenghuo.yishenghuo.bean.NewsBean;
import com.yishenghuo.yishenghuo.bean.UserBean;
import com.yishenghuo.yishenghuo.bean.WeatherBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * 天气查询接口
 */
public interface ApiService {
    String WEATHER_BASE_URL = "https://free-api.heweather.com/v5/";
    String BASE_URL = "http://123.207.18.66:8000/api/";
    String NEWS_BASE_URL = "http://api.jisuapi.com/news/";

    @GET("get?")
    Observable <NewsBean> getNewsInfo(@Query("channel") String channel, @Query("appkey") String key);

    @GET("weather?")
    Observable <WeatherBean> getWeatherInfo(@Query("city") String city, @Query("key") String key);

    @POST("login_page")
    Observable <UserBean> getUser(@Body RequestBody body);

    @POST("register")
    Observable <UserBean> getVerifyCode(@Body RequestBody body);

    @POST("register_verify_code")
    Observable <UserBean> register(@Body RequestBody body);
}

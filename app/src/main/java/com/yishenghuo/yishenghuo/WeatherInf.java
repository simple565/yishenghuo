package com.yishenghuo.yishenghuo;

import com.yishenghuo.yishenghuo.bean.WeatherBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 天气查询接口
 */
public interface WeatherInf {
    String BASE_URL = "https://free-api.heweather.com/v5/";
    @GET("weather?")
    Flowable<WeatherBean> getWeatherInfo(@Query("city") String city, @Query("key") String key);
    // 注解里传入 网络请求 的部分URL地址
    // Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
    // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
    // getCall()是接受网络请求数据的方法
}

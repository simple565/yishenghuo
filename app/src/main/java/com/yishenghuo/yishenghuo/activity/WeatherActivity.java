package com.yishenghuo.yishenghuo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yishenghuo.yishenghuo.ApiService;
import com.yishenghuo.yishenghuo.DataManager;
import com.yishenghuo.yishenghuo.Model.bean.WeatherBean;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.util.LocationUtil;
import com.yishenghuo.yishenghuo.util.WeatherUtil;
import com.yishenghuo.yishenghuo.adapter.DayForecastAdapter;
import com.yishenghuo.yishenghuo.adapter.SuggestionsListAdapter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherActivity extends AppCompatActivity {

    private Context mContext;
    private LinearLayout view_city, view_time;
    private TextView tv_city, tv_time;
    private ImageView iv_refresh;
    private Animation mRefreshAnim;
    private ImageView iv_weather_icon;
    private TextView tv_temper, tv_temper_ranger, tv_icon_expression;
    private TextView tv_air_quality;
    private GridView gv_forecast;
    private ListView lv_suggestion;
    private ImageButton ibt_shutdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_weather);
        iniView();
        getWeather();
    }

    /**
     * 初始化空间，设置监听器
     * 初始化刷新动画，设置时间
     */
    public void iniView() {
        view_time = (LinearLayout) findViewById(R.id.weather_layout_refresh);
        tv_time = (TextView) findViewById(R.id.weather_tv_time);
        tv_city = (TextView) findViewById(R.id.weather_city);
        iv_refresh = (ImageView) findViewById(R.id.weather_iv_refresh);
        iv_weather_icon = (ImageView) findViewById(R.id.weather_icon);
        tv_temper = (TextView) findViewById(R.id.weather_temper);
        tv_temper_ranger = (TextView) findViewById(R.id.weather_temper_ranger);
        tv_icon_expression = (TextView) findViewById(R.id.weather_icon_expression);

        mRefreshAnim = AnimationUtils.loadAnimation(this, R.anim.refresh);
        view_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_refresh.setAnimation(mRefreshAnim);//开始动画
                getWeather();
            }
        });

        ibt_shutdown = (ImageButton) findViewById(R.id.weather_cancel);
        ibt_shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_air_quality = (TextView) findViewById(R.id.weather_tv_air_quality);
        gv_forecast = (GridView) findViewById(R.id.weather_gv_forecast);
        lv_suggestion = (ListView) findViewById(R.id.lv_suggestion);
    }

    /**
     * 天气数据请求
     */
    public void getWeather() {
        final String API_KEY = "424221e37aa3416da20a478cdccc3351";
        final String city = LocationUtil.getLocation(this);
        DataManager.getInstance ().changeUrl ( ApiService.WEATHER_BASE_URL );
        DataManager.getInstance ().getApiService ()
                .getWeatherInfo ( city,API_KEY )
                .subscribeOn ( Schedulers.io ())
                .observeOn ( AndroidSchedulers.mainThread () )
                .subscribe ( new Observer <WeatherBean> () {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        showWeather ( weatherBean );
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }

    /**
     * 显示天气数据
     *
     * @param weatherBean 天气数据模型
     */
    public void showWeather(WeatherBean weatherBean) {
        tv_city.setText(weatherBean.getHeWeather5().get(0).getBasic().getCity());//城市
        tv_time.setText(WeatherUtil.getTime(weatherBean.getHeWeather5().get(0).getBasic().getUpdate().getLoc()));//刷新时间WeatherUtil.getSmallIcon(weatherBean.getHeWeather5().get(0).getNow().getCond().getCode())
        iv_weather_icon.setBackgroundResource(R.mipmap.ic_sunny_cloudy_l);//设置天气图标
        iv_weather_icon.setScaleType(ImageView.ScaleType.FIT_XY);
        tv_temper.setText(weatherBean.getHeWeather5().get(0).getNow().getTmp());//当前温度
        tv_temper_ranger.setText(weatherBean.getHeWeather5().get(0).getDaily_forecast().get(0).getTmp().getRanger());//温度范围
        tv_icon_expression.setText(weatherBean.getHeWeather5().get(0).getNow().getCond().getTxt());//天气描述
        gv_forecast.setAdapter(new DayForecastAdapter(this,
                weatherBean.getHeWeather5().get(0).getDaily_forecast(),
                weatherBean.getHeWeather5().get(0).getHourly_forecast()));
        //生活指数列表适配器
        lv_suggestion.setAdapter(new SuggestionsListAdapter(this,
                weatherBean.getHeWeather5().get(0).getSuggestion().getBrf(),
                weatherBean.getHeWeather5().get(0).getSuggestion().getDetail()));
        iv_refresh.clearAnimation();//动画解除

    }
}

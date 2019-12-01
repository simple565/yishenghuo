package com.maureen.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.bean.WeatherBean;
import com.maureen.yishenghuo.util.WeatherUtil;

import java.util.List;

/**
 * Created by Lian on 2018/1/29.
 */

public class DayForecastAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<WeatherBean.HeWeather5Bean.DailyForecastBean> mDailyForecastBeans;
    private List<WeatherBean.HeWeather5Bean.HourlyForecastBean> mHourlyForecastBeans;
    private int index = 1;

    public DayForecastAdapter(Context context, List<WeatherBean.HeWeather5Bean.DailyForecastBean> mDailyForecastBeans,
                              List<WeatherBean.HeWeather5Bean.HourlyForecastBean> mHourlyForecastBeans) {
        layoutInflater = LayoutInflater.from(context);
        this.mDailyForecastBeans = mDailyForecastBeans;
        this.mHourlyForecastBeans = mHourlyForecastBeans;
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_weather_forecast, null);
        }
        TextView tv_date = (TextView) convertView.findViewById(R.id.item_forecast_tv_day);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.item_forecast_iv_icon);
        TextView tv_temp = (TextView) convertView.findViewById(R.id.item_forecast_tv_temp);
        if (position < 3) {
            tv_date.setText(WeatherUtil.getTime(mHourlyForecastBeans.get(position).getDate()));
            iv_icon.setBackgroundResource(WeatherUtil.getSmallIcon(mHourlyForecastBeans.get(position).getCond().getCode()));
            tv_temp.setText(mHourlyForecastBeans.get(position).getTmp());
        } else {
            iv_icon.setBackgroundResource(WeatherUtil.getSmallIcon(mDailyForecastBeans.get(index).getCond().getCode_d()));
            tv_temp.setText(mDailyForecastBeans.get(index).getTmp().getRanger());
            if (index == 1) {
                tv_date.setText("明天");
            } else {
                tv_date.setText("后天");
            }
            index = index + 1;
        }
        return convertView;
    }

    class ViewHolder {

    }
}

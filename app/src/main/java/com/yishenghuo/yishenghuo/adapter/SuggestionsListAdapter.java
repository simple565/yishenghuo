package com.yishenghuo.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yishenghuo.yishenghuo.R;

/**
 * Created by ihome on 2017/7/31.
 */

public class SuggestionsListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private final static int[] img={R.drawable.ic_weather_comfort, R.drawable.ic_weather_close,
            R.drawable.ic_weather_pill, R.drawable.ic_weather_sport,
            R.drawable.ic_weather_wash_car, R.drawable.ic_weather_travel};
    private final static String[] suggestionname = {"舒适度指数","穿衣指数",
            "感冒指数","运动指数",
             "洗车指数", "旅游指数" };
    private String[] brief = new String[suggestionname.length];
    private String[] details = new String[suggestionname.length];

    public SuggestionsListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public SuggestionsListAdapter(Context context, String[] brief, String[] details) {
        super();
        this.brief = brief;
        this.details = details;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return suggestionname.length;
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.weather_suggestion_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_icon =(ImageView)convertView.findViewById(R.id.item_suggestion_iv_icon);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.item_suggestion_tv_name);
            viewHolder.tv_brief = (TextView) convertView.findViewById(R.id.item_suggestion_tv_brief);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_icon.setBackgroundResource(img[position]);
        viewHolder.tv_name.setText(suggestionname[position]);
        viewHolder.tv_brief.setText(brief[position]);


        return convertView;
    }

    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_brief;

    }
}

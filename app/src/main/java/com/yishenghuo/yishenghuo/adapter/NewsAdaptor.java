package com.yishenghuo.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yishenghuo.yishenghuo.bean.NewsBean;
import com.yishenghuo.yishenghuo.R;

import java.util.List;

/**
 * Created by Lian on 2018/2/16.
 */

public class NewsAdaptor extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<NewsBean.ResultBean.ListBean> mResultBeanList;

    public NewsAdaptor(Context context) {
        super();
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public NewsAdaptor(Context context, List<NewsBean.ResultBean.ListBean> mResultBeanList) {
        super();
        this.mContext = context;
        this.mResultBeanList = mResultBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
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
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.news_list_item, null);
            viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.item_news_iv_pic);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.item_news_tv_title);
            viewHolder.tv_timeAndsrc = (TextView) convertView.findViewById(R.id.item_news_tv_time_src);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(mResultBeanList.get(position).getPic()).into(viewHolder.iv_icon);
        viewHolder.tv_title.setText(mResultBeanList.get(position).getTitle());
        String temp = mResultBeanList.get(position).getTime() + " " + mResultBeanList.get(position).getSrc();
        viewHolder.tv_timeAndsrc.setText(temp);
        return convertView;
    }

    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_title;
        TextView tv_timeAndsrc;
    }
}

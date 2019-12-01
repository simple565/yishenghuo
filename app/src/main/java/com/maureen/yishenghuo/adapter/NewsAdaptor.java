package com.maureen.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.bean.NewsBean;

import java.util.List;

/**
 * @Description 新闻列表适配器
 * @Author Lianml
 * @Create 2018/2/16
 */
public class NewsAdaptor extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<NewsBean.ResultBean.ListBean> mResultBeanList;

    public NewsAdaptor(Context context, List<NewsBean.ResultBean.ListBean> mResultBeanList) {
        super();
        this.mContext = context;
        this.mResultBeanList = mResultBeanList;
        mLayoutInflater = LayoutInflater.from(context);
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
            convertView = mLayoutInflater.inflate(R.layout.item_news, null);
            viewHolder.iconIv = convertView.findViewById(R.id.item_news_iv_pic);
            viewHolder.titleTv = convertView.findViewById(R.id.item_news_tv_title);
            viewHolder.timeAndSrcTv = convertView.findViewById(R.id.item_news_tv_time_src);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(mResultBeanList.get(position).getPic()).into(viewHolder.iconIv);
        viewHolder.titleTv.setText(mResultBeanList.get(position).getTitle());
        String temp = mResultBeanList.get(position).getTime() + " " + mResultBeanList.get(position).getSrc();
        viewHolder.timeAndSrcTv.setText(temp);
        return convertView;
    }

    static class ViewHolder {
        ImageView iconIv;
        TextView titleTv;
        TextView timeAndSrcTv;
    }
}

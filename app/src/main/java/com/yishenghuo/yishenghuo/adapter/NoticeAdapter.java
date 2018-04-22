package com.yishenghuo.yishenghuo.adapter;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;


import com.yishenghuo.yishenghuo.Model.bean.NoticeBean;
import com.yishenghuo.yishenghuo.R;

import java.util.List;

public class NoticeAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Context mContext;
    private List<NoticeBean.DataBean> mResultBeanList;


    public NoticeAdapter(Context context, List<NoticeBean.DataBean> mResultBeanList) {
        super();
        this.mContext = context;
        this.mResultBeanList = mResultBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mResultBeanList.size();
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
            convertView = layoutInflater.inflate(R.layout.notice_list_item, null);
            viewHolder.tv_details = (TextView) convertView.findViewById(R.id.item_notice_tv_detail);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.item_notice_tv_title);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.item_notice_tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_time.setText(mResultBeanList.get(position).getNotice_time());
        viewHolder.tv_title.setText(mResultBeanList.get(position).getNotice_title());
        viewHolder.tv_details.setText(mResultBeanList.get(position).getNotice_details());

        return convertView;
    }

    static class ViewHolder {
        TextView tv_time;
        TextView tv_title;
        TextView tv_details;
    }
}

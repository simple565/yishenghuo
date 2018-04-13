package com.yishenghuo.yishenghuo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yishenghuo.yishenghuo.Model.bean.CommunityActivityBean;

import java.util.List;

public class CommunityActivityAdapter extends BaseAdapter {
    private List<CommunityActivityBean> mBeanList;

    @Override
    public int getCount() {
        return mBeanList == null ? 0 : mBeanList.size();
    }

    @Override
    public CommunityActivityBean getItem(int position) {
        return mBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
    static class ViewHolder{
        ImageView mImageView;
        TextView tv_description;
       // TextView tv_
    }
}

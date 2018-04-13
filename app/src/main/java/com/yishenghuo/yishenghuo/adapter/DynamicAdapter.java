package com.yishenghuo.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.yishenghuo.yishenghuo.Model.bean.DynamicItemBean;
import com.yishenghuo.yishenghuo.R;

import java.util.List;

public class DynamicAdapter extends BaseAdapter {
    private List<DynamicItemBean> mDynamicItemBeanList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public DynamicAdapter(Context context, List<DynamicItemBean> mDynamicItemBeanList) {
        super();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDynamicItemBeanList = mDynamicItemBeanList;
    }
    public void setData(DynamicItemBean dynamicItemBean){
        mDynamicItemBeanList.add(dynamicItemBean);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDynamicItemBeanList.size();
    }

    @Override
    public DynamicItemBean getItem(int position) {
        return mDynamicItemBeanList.get(position);
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
            convertView = mLayoutInflater.inflate(R.layout.dynamic_list_item, null);
            viewHolder.mImageView = convertView.findViewById(R.id.item_dynamic_iv_icon);
            viewHolder.mTextView_title = convertView.findViewById(R.id.item_dynamic_tv_name);
            viewHolder.mTextView_description = convertView.findViewById(R.id.item_dynamic_tv_brf);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(mDynamicItemBeanList.get(position).getImgURL()).into(viewHolder.mImageView);
        viewHolder.mTextView_title.setText(mDynamicItemBeanList.get(position).getTitle());
        viewHolder.mTextView_description.setText(mDynamicItemBeanList.get(position).getDescription());
        return convertView;
    }

    static class ViewHolder {
        ImageView mImageView;
        TextView mTextView_title;
        TextView mTextView_description;
    }
}

package com.yishenghuo.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yishenghuo.yishenghuo.Model.bean.HealthEntity;
import com.yishenghuo.yishenghuo.R;

import java.util.List;

/**
 * @author Lian
 * @create 2018/4/22
 * @Describe
 */
public class HealthAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List <HealthEntity.NewslistBean> mList;

    public HealthAdapter(Context context, List <HealthEntity.NewslistBean> mList) {
        this.mList = mList;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from ( context );
    }


    @Override
    public int getCount() {
        return mList.size ();
    }

    @Override
    public HealthEntity.NewslistBean getItem(int position) {
        return mList.get ( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder ();
            convertView = mLayoutInflater.inflate ( R.layout.news_list_item, null );
            viewHolder.iv_icon = (ImageView) convertView.findViewById ( R.id.item_news_iv_pic );
            viewHolder.tv_title = (TextView) convertView.findViewById ( R.id.item_news_tv_title );
            viewHolder.tv_timeAndsrc = (TextView) convertView.findViewById ( R.id.item_news_tv_time_src );
            convertView.setTag ( viewHolder );
        } else {
            viewHolder = (ViewHolder) convertView.getTag ();
        }
        Glide.with ( mContext ).load ( mList.get ( position ).getPicUrl () ).into ( viewHolder.iv_icon );
        viewHolder.tv_title.setText ( mList.get ( position ).getTitle () );
        String temp = mList.get ( position ).getCtime () + " " + mList.get ( position ).getDescription ();
        viewHolder.tv_timeAndsrc.setText ( temp );
        return convertView;
    }

    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_title;
        TextView tv_timeAndsrc;
    }
}

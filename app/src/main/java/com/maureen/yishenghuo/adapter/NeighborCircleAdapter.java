package com.maureen.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.bean.NeighborCircleEntity;

import java.util.List;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;

/**
 * @author Lian
 * @create 2018/4/24
 * @Describe 邻居圈数据适配器
 */
public class NeighborCircleAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<NeighborCircleEntity.DataBean> mEntityList;

    public NeighborCircleAdapter(Context context, List<NeighborCircleEntity.DataBean> entityList) {
        super();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mEntityList = entityList;

    }

    @Override
    public int getCount() {
        return mEntityList.size();
    }

    @Override
    public NeighborCircleEntity.DataBean getItem(int position) {
        return mEntityList.get(position);
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
            convertView = mLayoutInflater.inflate(R.layout.item_neighbor_circle, null);
            viewHolder.mImageView = convertView.findViewById(R.id.item_neighbor_circle_icon);
            viewHolder.nickname = convertView.findViewById(R.id.item_neighbor_circle_nickname);
            viewHolder.content = convertView.findViewById(R.id.item_neighbor_circle_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mImageView.setBackgroundResource(R.mipmap.ic_my_favicon);
        viewHolder.nickname.setText(mEntityList.get(position).getContent().getNickname());
        viewHolder.content.setText(mEntityList.get(position).getContent().getContent());
        return convertView;
    }

    static class ViewHolder {
        ImageView mImageView;
        TextView nickname;
        ExpandableTextView content;
    }
}

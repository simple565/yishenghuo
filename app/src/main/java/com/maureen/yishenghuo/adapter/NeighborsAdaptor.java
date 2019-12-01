package com.maureen.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.bean.NeighborsBean;

import java.util.List;

public class NeighborsAdaptor extends RecyclerView.Adapter<NeighborsAdaptor.ViewHolder> {
    private List<NeighborsBean> mNeighborsBeanList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public NeighborsAdaptor(Context context, List<NeighborsBean> mNeighborsBeanList) {
        super();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mNeighborsBeanList = mNeighborsBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(mLayoutInflater.inflate(R.layout.item_neighbors,
                parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(mNeighborsBeanList.get(position).getFaviconURL()).into(holder.iv_favicon);
        holder.tv_nickname.setText(mNeighborsBeanList.get(position).getNickname());
    }

    @Override
    public int getItemCount() {
        return mNeighborsBeanList == null ? 0 : mNeighborsBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_favicon;
        TextView tv_nickname;
        ImageView iv_add;
        ImageView iv_chat;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_favicon = itemView.findViewById(R.id.item_neighbors_iv_favicon);
            tv_nickname = itemView.findViewById(R.id.item_neighbors_tv_nickname);
            iv_add = itemView.findViewById(R.id.item_neighbors_iv_add);
            iv_chat = itemView.findViewById(R.id.item_neighbors_iv_chat);
        }
    }
}

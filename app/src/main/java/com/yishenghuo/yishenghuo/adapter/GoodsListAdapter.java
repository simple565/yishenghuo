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
 * Created by Lian on 2017/7/30.
 */

public class GoodsListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;

    private int[] images = {R.drawable.goods_03, R.drawable.goods_04,
            R.drawable.goods_01, R.drawable.goods_02,
            R.drawable.goods_01, R.drawable.goods_02,
            R.drawable.goods_03, R.drawable.goods_04};
    private String[] goods_name = {"缴费", "缴费", "缴费", "缴费", "缴费", "缴费", "缴费", "缴费"};
    private String[] goods_price = {"惊爆价：", "促销价：", "惊爆价：", "促销价：", "惊爆价：",
            "促销价：", "惊爆价：", "促销价："};

    public GoodsListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.goods_gridview_item, null);

        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_iv);
        TextView textView_name = (TextView) convertView.findViewById(R.id.item_tv_name);
        TextView textView_price = (TextView) convertView.findViewById(R.id.item_tv_price);
        imageView.setImageResource(images[position]);
        textView_name.setText(goods_name[position]);
        textView_price.setText(goods_price[position]);
        return convertView;
    }

}

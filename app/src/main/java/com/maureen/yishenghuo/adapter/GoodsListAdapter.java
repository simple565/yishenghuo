package com.maureen.yishenghuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maureen.yishenghuo.R;

/**
 * @Description 商品列表适配器
 * @Author Lianml
 * @Create 2017/7/30.
 */
public class GoodsListAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;

    private int[] images = {R.mipmap.goods_03, R.mipmap.goods_04,
            R.mipmap.goods_01, R.mipmap.goods_02,
            R.mipmap.goods_01, R.mipmap.goods_02,
            R.mipmap.goods_03, R.mipmap.goods_04};
    private String[] goods_name = {"短袖", "厨具", "飘柔洗发水", "水果",
            "飘柔洗发水", "水果", "短袖", "厨具"};
    private String[] goods_price = {"￥39.9", "￥199.9", "￥9.9", "￥29.9",
            "￥29.9", "￥9.9", "￥39.9", "￥199.9"};

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
            convertView = layoutInflater.inflate(R.layout.item_goods, null);

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

package com.yishenghuo.yishenghuo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.oragee.banners.BannerView;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;
import com.yishenghuo.yishenghuo.adapter.GoodsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MallFragment extends Fragment {

    private TitleBar mtitleBar;
    private GridView mgridView;
    private List<View> viewList;
    private int[] imgs = {R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner};

    public MallFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mall, container, false);
        iniView(view);
        return view;

    }

    public void iniView(View view) {
        mtitleBar = (TitleBar) view.findViewById(R.id.mall_titlebar);
        mtitleBar.setText("商城");
        BannerView mbannerView = (BannerView) view.findViewById(R.id.mall_bannerview);
        mbannerView.startLoop(true);
        iniViewList(imgs);
        mbannerView.setViewList(viewList);
        mgridView = (GridView) view.findViewById(R.id.mall_gv);
        mgridView.setAdapter(new GoodsListAdapter(getContext()));
    }

    /**
     * 初始化banner图片
     */
    private void iniViewList(int[] imgs) {
        viewList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageview = new ImageView(getActivity());
            imageview.setBackgroundResource(imgs[i]);
            viewList.add(imageview);
        }
    }


}

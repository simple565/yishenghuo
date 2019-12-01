package com.maureen.yishenghuo.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.adapter.GoodsListAdapter;
import com.maureen.yishenghuo.ui.TitleBar;
import com.oragee.banners.BannerView;

import java.util.ArrayList;
import java.util.List;

public class MallFragment extends Fragment {

    private TitleBar mtitleBar;
    private GridView mgridView;
    private List<View> viewList;
    private int[] imgs = {R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner};

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

package com.yishenghuo.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.oragee.banners.BannerView;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.activity.DynamicActivity;
import com.yishenghuo.yishenghuo.activity.NeighborCircleActivity;
import com.yishenghuo.yishenghuo.activity.NeighborsActivity;
import com.yishenghuo.yishenghuo.ui.weiget.TitleBar;
import com.yishenghuo.yishenghuo.activity.NewsActivity;

import java.util.ArrayList;
import java.util.List;

public class NeighborFragment extends Fragment {
    private TextView activities, news, hot_topic;
    private TitleBar mTitleBar;
    private RelativeLayout neighbor_circle, dynamic, neighbors;
    private List<View> viewList;
    private int[] imgs = {R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner};

    public NeighborFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neighbor, container, false);
        ini(view);
        return view;
    }

    /**
     * 初始化控件，设置监听器
     *
     * @param view
     */
    public void ini(View view) {
        mTitleBar = (TitleBar) view.findViewById(R.id.neighbor_titlebar);
        mTitleBar.setText("邻里");

        BannerView bannerView = (BannerView) view.findViewById(R.id.neighbor_bannerview);
        bannerView.startLoop(true);
        iniViewList(imgs);
        bannerView.setViewList(viewList);


        activities = (TextView) view.findViewById(R.id.neighbor_tv_activity);
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "小区活动", Toast.LENGTH_LONG).show();
            }
        });
        news = (TextView) view.findViewById(R.id.neighbor_tv_news);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewsActivity.class));
            }
        });
        hot_topic = (TextView) view.findViewById(R.id.neighbor_tv_hot);
        hot_topic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "热门话题", Toast.LENGTH_LONG).show();
            }
        });

        neighbor_circle = (RelativeLayout) view.findViewById(R.id.neighbor_rl_circle);
        neighbor_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NeighborCircleActivity.class));
            }
        });

        dynamic = (RelativeLayout) view.findViewById(R.id.neighbor_rl_dynamic);
        dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DynamicActivity.class));
            }
        });

        neighbors = (RelativeLayout) view.findViewById(R.id.neighbor_rl_neighbors);
        neighbors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NeighborsActivity.class));
            }
        });
    }

    private void iniViewList(int[] imgs) {
        viewList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageview = new ImageView(getActivity());
            imageview.setBackgroundResource(imgs[i]);
            viewList.add(imageview);

        }
    }

}

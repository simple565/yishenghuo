package com.maureen.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.neighborhood.DynamicActivity;
import com.maureen.yishenghuo.neighborhood.HealthActivity;
import com.maureen.yishenghuo.neighborhood.NeighborCircleActivity;
import com.maureen.yishenghuo.neighborhood.NeighborsActivity;
import com.maureen.yishenghuo.neighborhood.NewsActivity;
import com.maureen.yishenghuo.ui.TitleBar;
import com.oragee.banners.BannerView;

import java.util.ArrayList;
import java.util.List;

public class NeighborFragment extends Fragment {
    private TextView activities, news, hot_topic;
    private TitleBar mTitleBar;
    private RelativeLayout neighbor_circle, dynamic, neighbors;
    private List<View> viewList;
    private int[] imgs = {R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner};

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
                startActivity(new Intent(getActivity(), HealthActivity.class));
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

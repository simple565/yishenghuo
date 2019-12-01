package com.maureen.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.activity.PropertyApplyActivity;
import com.maureen.yishenghuo.neighborhood.MessageActivity;
import com.maureen.yishenghuo.servicesupport.EntranceActivity;
import com.maureen.yishenghuo.servicesupport.NoticeActivity;
import com.maureen.yishenghuo.servicesupport.RepairsActivity;
import com.oragee.banners.BannerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<View> viewList;
    private int[] imgs = {R.mipmap.banner, R.mipmap.banner, R.mipmap.banner, R.mipmap.banner};
    private EditText mEditText;

    private String[] hot = {"震惊！某业主半夜起床竟发现！", "震惊！小物件暗藏大能量！"};

    public HomeFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        iniView(view);
        return view;
    }

    /**
     * 初始化控件,设置监听器
     *
     * @param view
     */
    private void iniView(View view) {
        BannerView bannerView = view.findViewById(R.id.home_bannerview);
        iniViewList(imgs);
        bannerView.startLoop(true);
        bannerView.setViewList(viewList);

        ImageButton mLocateBtn = view.findViewById(R.id.home_location);
        mLocateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent ( getActivity (), MapActivity.class ); //LoginActivity.class
                startActivity ( intent );*/
            }
        });
        ImageView mMsgBtn = (ImageButton) view.findViewById(R.id.home_title_message);
        mMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout mEntranceLayout =  view.findViewById(R.id.home_ll_entrance);
        mEntranceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EntranceActivity.class));
            }
        });
        LinearLayout mNotificationLayout =  view.findViewById(R.id.home_ll_notification);
        mNotificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NoticeActivity.class));
            }
        });
        LinearLayout mPaymentLayout =  view.findViewById(R.id.home_ll_payment);
        mPaymentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PropertyApplyActivity.class));
            }
        });
        LinearLayout mReparirLyout = view.findViewById(R.id.home_ll_repair);
        mReparirLyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RepairsActivity.class));
            }
        });

        mEditText = view.findViewById(R.id.home_edt_search);
        //设置背景色的透明度
        mEditText.getBackground().setAlpha(100);
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setCursorVisible(true);
            }
        });
        TextView mTimeTv = view.findViewById(R.id.home_activity_time);
    }

    /**
     * 初始化banner图片
     * @param imgs 图片集合
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

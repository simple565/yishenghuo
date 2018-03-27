package com.yishenghuo.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.BannerView;
import com.yishenghuo.yishenghuo.activity.LoginActivity;
import com.yishenghuo.yishenghuo.activity.MessageActivity;
import com.yishenghuo.yishenghuo.adapter.GoodsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private BannerView bannerView;
    private List<View> viewList;
    private int[] imgs = {R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner};
    private ImageView btn_mengjin, btn_weixiu, btn_tongzhi, btn_jiaofei, btn_locate,btn_msg;
    private GridView gridView;
    private EditText editText;
    private TextSwitcher ts;


    private ArrayList<ImageView> viewlist;
    private ArrayList<ImageView> dotlist;
    private bitHandler bitHandler;
    private int index = 0;


    private int[] images = {R.drawable.goods_03, R.drawable.goods_04,
            R.drawable.goods_01, R.drawable.goods_02,
            R.drawable.goods_01, R.drawable.goods_02,
            R.drawable.goods_03, R.drawable.goods_04};

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
        ini(view);

        ts.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(getContext());
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                lp.gravity = Gravity.CENTER_VERTICAL;
                tv.setLayoutParams(lp);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "今日热点", Toast.LENGTH_SHORT).show();
                    }
                });
                return tv;
            }
        });

        bitHandler = new bitHandler();
        new myThread().start();
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setCursorVisible(true);
            }
        });


        return view;
    }

    /**
     * 初始化控件,设置监听器
     *
     * @param view
     */
    private void ini(View view) {
        bannerView = (BannerView) view.findViewById(R.id.home_bannerview);
        iniViewList(imgs);
        bannerView.startLoop(true);
        bannerView.setViewList(viewList);

        btn_locate = (ImageButton) view.findViewById(R.id.home_location);
        btn_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_msg=(ImageButton)view.findViewById(R.id.home_title_message);
        btn_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
            }
        });
        btn_mengjin = (ImageView) view.findViewById(R.id.home_bt_mengjin);
        btn_mengjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "我是门禁", Toast.LENGTH_SHORT).show();
            }
        });
        btn_tongzhi = (ImageView) view.findViewById(R.id.home_bt_tongzhi);
        btn_jiaofei = (ImageView) view.findViewById(R.id.home_bt_jiaofei);
        btn_weixiu = (ImageView) view.findViewById(R.id.home_bt_weixiu);

        gridView = (GridView) view.findViewById(R.id.home_gv_goods);
        gridView.setAdapter(new GoodsListAdapter(view.getContext()));

        ts = (TextSwitcher) view.findViewById(R.id.ts);
        editText = (EditText) view.findViewById(R.id.home_edt_search);
        editText.getBackground().setAlpha(100);//设置背景色的透明度

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

    class bitHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ts.setText(hot[index]);
            index++;
            if (index == hot.length)
                index = 0;
        }
    }

    class myThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (index < hot.length) {
                try {
                    synchronized (getActivity()) {
                        bitHandler.sendEmptyMessage(0);
                        this.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

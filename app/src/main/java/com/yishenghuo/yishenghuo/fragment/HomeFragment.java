package com.yishenghuo.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
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

import com.oragee.banners.BannerView;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.activity.EntranceActivity;
import com.yishenghuo.yishenghuo.activity.LoginActivity;
import com.yishenghuo.yishenghuo.Neighborhood.MessageActivity;
import com.yishenghuo.yishenghuo.adapter.GoodsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<View> viewList;
    private int[] imgs = {R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner};
    private ImageView btn_locate, btn_msg;
    private GridView gridView;
    private EditText editText;
    private TextSwitcher ts;


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
        iniView(view);

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
    private void iniView(View view) {
        BannerView bannerView = view.findViewById(R.id.home_bannerview);
        iniViewList(imgs);
        bannerView.startLoop(true);
        bannerView.setViewList(viewList);

        ImageButton btn_locate = (ImageButton) view.findViewById(R.id.home_location);
        btn_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_msg = (ImageButton) view.findViewById(R.id.home_title_message);
        btn_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
            }
        });
        ImageView iv_entrance = (ImageView) view.findViewById(R.id.home_btn_entrance);
        iv_entrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EntranceActivity.class));
            }
        });
        ImageView iv_notification = (ImageView) view.findViewById(R.id.home_btn_notification);
        ImageView iv_payment = (ImageView) view.findViewById(R.id.home_btn_payment);
        ImageView iv_repair = (ImageView) view.findViewById(R.id.home_btn_repair);

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
}

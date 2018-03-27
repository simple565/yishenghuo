package com.yishenghuo.yishenghuo.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.activity.MessageActivity;
import com.yishenghuo.yishenghuo.adapter.NeighborsAdaptor;

/**
 * 自定义顶部标题栏，包含标题，消息按钮
 */
public class TitleBar extends RelativeLayout {
    private ImageButton btn_right, btn_left;//右边按钮(固定为message)、左边按钮
    private TextView textView;
    private Context mContext;

    public TitleBar(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public void initView() {


        RelativeLayout.LayoutParams bt = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        bt.addRule(ALIGN_PARENT_END, TRUE);
        bt.addRule(CENTER_VERTICAL, TRUE);
        RelativeLayout.LayoutParams tv = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        tv.addRule(CENTER_IN_PARENT, TRUE);


        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        btn_left = new ImageButton(getContext());
        btn_right = new ImageButton(getContext());
        btn_right.setBackgroundResource(R.drawable.ic_message);//默认为message图标
        btn_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageActivity.class);
                getContext().startActivity(intent);
            }
        });
        textView = new TextView(getContext());
        textView.setGravity(CENTER_IN_PARENT);
        textView.setText("");
        addView(textView, tv);
        addView(btn_right, bt);

    }

    //设置标题
    public void setText(String string) {
        textView.setText(string);
        textView.setTextSize(20);
        textView.setTextColor(getResources().getColor(R.color.white));
    }

    //设置右边button
    public void setRightButton(@DrawableRes int id) {
        btn_right.setBackgroundResource(id);
    }

    //设置左边button
    public void setLeftButton(@DrawableRes int id) {
        btn_left.setBackgroundResource(id);
        RelativeLayout.LayoutParams bt = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        bt.addRule(ALIGN_PARENT_START, TRUE);
        bt.addRule(CENTER_VERTICAL, TRUE);
        addView(btn_left, bt);

    }

    //设置左边button监听器
    public void setLeftButtonClickListener(OnClickListener listener) {
        btn_left.setOnClickListener(listener);
    }

    //设置右边button监听器
    public void setRightButtonClickListener(OnClickListener listener) {
        btn_right.setOnClickListener(listener);
    }
}
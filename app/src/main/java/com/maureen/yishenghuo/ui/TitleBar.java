package com.maureen.yishenghuo.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.neighborhood.MessageActivity;

/**
 * 自定义顶部标题栏，包含标题，消息按钮
 */
public class TitleBar extends RelativeLayout {
    private ImageButton mRightBtn, mLeftBtn;//右边按钮(固定为message)、左边按钮
    private TextView mTitleTv;
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

        mLeftBtn = new ImageButton(getContext());
        mRightBtn = new ImageButton(getContext());
        mRightBtn.setBackgroundResource(R.drawable.ic_message_white);//默认为message图标
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageActivity.class);
                getContext().startActivity(intent);
            }
        });
        mTitleTv = new TextView(getContext());
        mTitleTv.setGravity(CENTER_IN_PARENT);
        mTitleTv.setText("");
        addView(mTitleTv, tv);
        addView(mRightBtn, bt);
    }

    //设置标题
    public void setText(String string) {
        mTitleTv.setText(string);
        mTitleTv.setTextSize(20);
        mTitleTv.setTextColor(getResources().getColor(R.color.white));
    }

    //设置右边button
    public void setRightButton(@DrawableRes int id) {
        mRightBtn.setBackgroundResource(id);
    }

    //设置返回按键
    public void setHomeIcon() {
        mLeftBtn.setBackgroundResource(R.drawable.ic_arrow_left);
    }

    //设置左边button
    public void setLeftButton(@DrawableRes int id) {
        mLeftBtn.setBackgroundResource(id);
        RelativeLayout.LayoutParams bt = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        bt.addRule(ALIGN_PARENT_START, TRUE);
        bt.addRule(CENTER_VERTICAL, TRUE);
        addView(mLeftBtn, bt);

    }

    //设置左边button监听器
    public void setLeftButtonClickListener(OnClickListener listener) {
        mLeftBtn.setOnClickListener(listener);
    }

    //设置右边button监听器
    public void setRightButtonClickListener(OnClickListener listener) {
        mRightBtn.setOnClickListener(listener);
    }
}
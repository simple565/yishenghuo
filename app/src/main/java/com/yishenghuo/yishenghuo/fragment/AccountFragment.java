package com.yishenghuo.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.activity.PropertyActivity;
import com.yishenghuo.yishenghuo.activity.SettingActivity;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class AccountFragment extends Fragment {
    private TitleBar mTitleBar;

    public AccountFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        iniView(view);
        return view;
    }

    protected void iniView(View view) {
        mTitleBar = (TitleBar) view.findViewById(R.id.account_titlebar);
        mTitleBar.setText("我的");
        mTitleBar.setLeftButton(R.drawable.ic_setting);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
    }
}

package com.yishenghuo.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.activity.FeedbackActivity;
import com.yishenghuo.yishenghuo.activity.SettingActivity;
import com.yishenghuo.yishenghuo.ui.TitleBar;

import okhttp3.internal.connection.RealConnection;

public class AccountFragment extends Fragment {
    private TitleBar mTitleBar;

    public AccountFragment() {
        super ();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.fragment_account, container, false );
        iniView ( view );
        return view;
    }

    protected void iniView(View view) {
        mTitleBar = (TitleBar) view.findViewById ( R.id.account_titlebar );
        mTitleBar.setText ( "我的" );
        mTitleBar.setLeftButton ( R.drawable.ic_setting );
        mTitleBar.setLeftButtonClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (), SettingActivity.class ) );
            }
        } );
        Button btn_exit = view.findViewById ( R.id.account_btn_quit );
        btn_exit.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                getActivity ().finish ();
            }
        } );

        RelativeLayout rl_feedback = view.findViewById ( R.id.account_feedback );
        rl_feedback.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (), FeedbackActivity.class ) );
            }
        } );
        RelativeLayout rl_about = view.findViewById ( R.id.account_about_us );
        rl_about.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getActivity (), FeedbackActivity.class ) );
            }
        } );
    }
}

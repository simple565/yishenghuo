package com.yishenghuo.yishenghuo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class Binding_phoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding_phone);
        iniView ();
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById ( R.id.binding_phone_titlebar);
        mTitleBar.setText ( "绑定手机号" );
        mTitleBar.setLeftButton ( R.drawable.ic_arrow_left );
        mTitleBar.setLeftButtonClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                finish ();
            }
        } );

    }
}

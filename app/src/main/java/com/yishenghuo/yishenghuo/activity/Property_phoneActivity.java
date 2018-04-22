package com.yishenghuo.yishenghuo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class Property_phoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_phone);
        iniView ();
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById ( R.id.property_phone_titlebar );
        mTitleBar.setText ( "物业电话" );
        mTitleBar.setLeftButton ( R.drawable.ic_arrow_left );
    }

}

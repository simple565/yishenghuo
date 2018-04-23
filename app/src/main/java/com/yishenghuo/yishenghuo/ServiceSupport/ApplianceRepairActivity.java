package com.yishenghuo.yishenghuo.ServiceSupport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class ApplianceRepairActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_appliance_repairs );
        iniView ();
    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById ( R.id.appliance_repairs_titlebar );
        mTitleBar.setText ( "家电维修" );
        mTitleBar.setLeftButton ( R.drawable.ic_arrow_left );
        mTitleBar.setLeftButtonClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                finish ();
            }
        } );

    }
}
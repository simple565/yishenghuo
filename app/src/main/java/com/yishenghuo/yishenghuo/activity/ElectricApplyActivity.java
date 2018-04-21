package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;

public class ElectricApplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_electric_apply );
        iniView ();


    }

    public void iniView() {
        TitleBar mTitleBar = (TitleBar) findViewById ( R.id.electric_apply_titlebar );
        mTitleBar.setText ( "新增缴费用户" );
        mTitleBar.setLeftButton ( R.drawable.ic_arrow_left );
        Button electric_next = (Button) findViewById ( R.id.electric_apple_next );
        electric_next.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( ElectricApplyActivity.this, ElectricActivity.class );
                startActivity ( intent );
            }
        } );
    }
}

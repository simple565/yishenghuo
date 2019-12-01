package com.maureen.yishenghuo.servicesupport;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.presenter.IllegalityPresenter;
import com.maureen.yishenghuo.ui.TitleBar;

public class IllegalityActivity extends AppCompatActivity {
    private IllegalityPresenter mPresenter;
    private String lsprefix, lsnum, lstype, engineno, frameno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illegality);
        iniView();
    }

    public void iniView() {
        TitleBar mTitleBar = findViewById(R.id.illegality_titlebar);
        mTitleBar.setText("违章查询");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        final Spinner sp_providence = findViewById(R.id.car_providence);
        sp_providence.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lsprefix = sp_providence.getItemAtPosition(position).toString();
            }
        });
        final Spinner sp_letter = findViewById(R.id.car_letter);
        sp_letter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lsnum = sp_letter.getItemAtPosition(position).toString();
            }
        });
        EditText edt_num = findViewById(R.id.car_number);
        lsnum += edt_num.getText();
        lstype = "02";
        TextView tv_engine = findViewById(R.id.car_engine);
        engineno = tv_engine.getText().toString();
        TextView tv_frameno = findViewById(R.id.car_carriage_num);
        frameno = tv_frameno.getText().toString();
        Button button = findViewById(R.id.illegality_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mPresenter.showResult ( RequestBodyUtil.getCarIllegal ( lsprefix, lsnum, lstype, engineno, frameno ) );
            }
        });

    }
}

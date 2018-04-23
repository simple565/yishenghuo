package com.yishenghuo.yishenghuo.ServiceSupport;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.yishenghuo.yishenghuo.Model.bean.NoticeBean;
import com.yishenghuo.yishenghuo.Neighborhood.MessageActivity;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.adapter.NoticeAdapter;
import com.yishenghuo.yishenghuo.ui.TitleBar;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity extends AppCompatActivity {

    private Context mContext;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        iniView();
        getNotice();
    }

    private void iniView() {

        TitleBar mTitleBar = (TitleBar) findViewById(R.id.notice_titlebar);
        mTitleBar.setText("物业公告");
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoticeActivity.this, MessageActivity.class));
            }
        });
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);
        mTitleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoticeActivity.this, Message.class));
            }
        });

        mListView = (ListView) findViewById(R.id.notice_list);
    }

    private void getNotice(){

        List<NoticeBean.DataBean> mlist = new ArrayList <>();

        NoticeBean.DataBean dataBeanl1 = new NoticeBean.DataBean();
        dataBeanl1.setNotice_title("停水通知");
        dataBeanl1.setNotice_time("2018年04月26日");
        dataBeanl1.setNotice_details("于2018年05月01日，全小区停原水，请各位户主注意存水。");
        mlist.add(dataBeanl1);

        NoticeBean.DataBean dataBeanl2 = new NoticeBean.DataBean();
        dataBeanl2.setNotice_title("物业缴交");
        dataBeanl2.setNotice_time("2018年04月15日");
        dataBeanl2.setNotice_details("请各位户主与2018年04月20日之前缴交第一季度的物业费，感谢您的配合！");
        mlist.add(dataBeanl2);

        NoticeBean.DataBean dataBeanl3 = new NoticeBean.DataBean();
        dataBeanl3.setNotice_title("请勿随意摆放");
        dataBeanl3.setNotice_time("2018年04月03日");
        dataBeanl3.setNotice_details("请各位户主不要随意存放自己的自行车或电动车，并在10日之前移走，逾期我们将强行搬运！");
        mlist.add(dataBeanl3);

        NoticeAdapter m=new NoticeAdapter(NoticeActivity.this,mlist);
        mListView.setAdapter(m);
    }
}

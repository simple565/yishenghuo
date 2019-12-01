package com.maureen.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.neighborhood.MessageActivity;
import com.maureen.yishenghuo.ui.TitleBar;

public class CommunityActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        iniView();
    }

    private void iniView() {
        TitleBar titleBar = findViewById(R.id.community_titlebar);
        titleBar.setLeftButton(R.drawable.ic_arrow_left);
        titleBar.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommunityActivity.this, MessageActivity.class));
            }
        });
        mListView = findViewById(R.id.community_list);
    }
}

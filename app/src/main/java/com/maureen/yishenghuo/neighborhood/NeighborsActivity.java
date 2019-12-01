package com.maureen.yishenghuo.neighborhood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.maureen.yishenghuo.R;

/**
 * author Lian
 * Description 同小区的人
 */

public class NeighborsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbors);
        iniData();
        iniView();
    }

    private void iniData() {

    }


    private void iniView() {
        ImageButton btn_back = findViewById(R.id.neighbors_btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton btn_message = findViewById(R.id.neighbors_btn_message);
        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NeighborsActivity.this, MessageActivity.class));
            }
        });
        final SearchView searchView = findViewById(R.id.neighbors_sv_search);
        searchView.getBackground().setAlpha(100);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //后台查询
                searchView.clearFocus();//收起键盘
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}

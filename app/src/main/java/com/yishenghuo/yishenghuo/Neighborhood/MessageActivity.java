package com.yishenghuo.yishenghuo.Neighborhood;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.yishenghuo.yishenghuo.R;

import java.lang.reflect.Field;

/**
 * author Lian
 * Description 消息
 */
public class MessageActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_message );
        iniView ();
    }

    private void iniView() {
        ImageButton btn_cancel = findViewById ( R.id.message_btn_back );
        btn_cancel.setOnClickListener ( this );
        TextView tv_friends = findViewById ( R.id.message_friends_list );
        tv_friends.setOnClickListener ( this );
        ImageButton btn_add = findViewById ( R.id.message_btn_add );
        btn_add.setOnClickListener ( this );

    }

    @SuppressLint("RestrictedApi")
    private void showPopMenu(View view) {
        PopupMenu popupMenu = new PopupMenu ( MessageActivity.this, view );
        try {
            Field field = popupMenu.getClass ().getDeclaredField ( "mPopup" );
            field.setAccessible ( true );
            MenuPopupHelper helper = (MenuPopupHelper) field.get ( popupMenu );
            helper.setForceShowIcon ( true );
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace ();
        }
        popupMenu.getMenuInflater ().inflate ( R.menu.add_more_friend, popupMenu.getMenu () );
        popupMenu.setOnMenuItemClickListener ( this );
        popupMenu.show ();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.add_scan:
                Toast.makeText ( this, "退出", Toast.LENGTH_SHORT ).show ();
                break;
            case R.id.add_start_chat:
                Toast.makeText ( this, "设置", Toast.LENGTH_SHORT ).show ();
                break;
            case R.id.add_add:
                startActivity ( new Intent ( MessageActivity.this,NeighborsActivity.class ) );
                break;
            default:
                break;
        }
        return false;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.message_btn_back:
                finish ();
                break;
            case R.id.message_btn_add:
                showPopMenu ( v );
                break;
            case R.id.message_friends_list:
                startActivity ( new Intent ( MessageActivity.this, ContactsActivity.class ) );
                break;

        }
    }
}

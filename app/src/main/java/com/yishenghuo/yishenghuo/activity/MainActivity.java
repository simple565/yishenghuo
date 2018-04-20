package com.yishenghuo.yishenghuo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.fragment.AccountFragment;
import com.yishenghuo.yishenghuo.fragment.HomeFragment;
import com.yishenghuo.yishenghuo.fragment.MallFragment;
import com.yishenghuo.yishenghuo.fragment.NeighborFragment;
import com.yishenghuo.yishenghuo.fragment.ServiceFragment;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.*;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private long PressTime = 0;

    private HomeFragment fragment_home;
    private ServiceFragment fragment_service;
    private MallFragment fragment_mall;
    private AccountFragment fragment_account;
    private NeighborFragment fragment_neighbor;


    FragmentManager fragmentmanager = getSupportFragmentManager ();
    FragmentTransaction transaction = fragmentmanager.beginTransaction ();
    //定义底部导航栏
    private ImageButton btn_home, btn_neighbor, btn_service, btn_mall, btn_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        iniView ();
        /**
         * 设置fragment_home为默认页
         */
        fragment_home = new HomeFragment ();
        transaction.add ( R.id.content, fragment_home );
        transaction.commit ();

    }

    /**
     * 双击返回键退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long NowTime = System.currentTimeMillis ();//获取第一次按键时间
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction () == KeyEvent.ACTION_DOWN) {
            if (NowTime - PressTime > 2000) {
                Toast.makeText ( getApplicationContext (), "再按一次退出程序", Toast.LENGTH_SHORT ).show ();
                PressTime = NowTime;//擦除第一次按钮
                return true;
            } else {
                System.exit ( 0 );
            }

        }
        return super.onKeyDown ( keyCode, event );
    }

    /**
     * 初始化控件，设置相关监听器
     */
    public void iniView() {
        BottomNavigationBar bottomNavigationBar = findViewById ( R.id.main_navigation_bar );
        bottomNavigationBar.addItem ( new BottomNavigationItem ( R.drawable.icon_home_select, "首页" ) )
                .addItem ( new BottomNavigationItem ( R.drawable.icon_neighbor_left, "邻里" ) )
                .addItem ( new BottomNavigationItem ( R.drawable.icon_service_left, "服务" ) )
                .addItem ( new BottomNavigationItem ( R.drawable.icon_account_left, "我的" ) )
                .initialise ();
        bottomNavigationBar.setTabSelectedListener ( this );
    }



   /* public void onClick(View view) {
        switch (view.getId ()) {
            case R.id.navigationbar_home:
                btn_home.setBackgroundResource ( R.drawable.icon_home_select );
                btn_neighbor.setBackgroundResource ( R.drawable.icon_neighbor_left );
                btn_service.setBackgroundResource ( R.drawable.icon_service_left );
                //btn_mall.setBackgroundResource(R.drawable.icon_mall_left);
                btn_account.setBackgroundResource ( R.drawable.icon_account_left );
                setLayoutItem ( 0 );
                break;
            case R.id.navigationbar_neighbor:
                btn_home.setBackgroundResource ( R.drawable.icon_home_right );
                btn_neighbor.setBackgroundResource ( R.drawable.icon_neighbor_select );
                btn_service.setBackgroundResource ( R.drawable.icon_service_left );
                // btn_mall.setBackgroundResource(R.drawable.icon_mall_left);
                btn_account.setBackgroundResource ( R.drawable.icon_account_left );
                setLayoutItem ( 1 );
                break;
            case R.id.navigationbar_service:
                btn_home.setBackgroundResource ( R.drawable.icon_home_right );
                btn_neighbor.setBackgroundResource ( R.drawable.icon_neighbor_right );
                btn_service.setBackgroundResource ( R.drawable.icon_service_select );
                // btn_mall.setBackgroundResource(R.drawable.icon_mall_left);
                btn_account.setBackgroundResource ( R.drawable.icon_account_left );
                setLayoutItem ( 2 );
                break;
          *//*  case R.id.navigationbar_mall:
                btn_home.setBackgroundResource(R.drawable.icon_home_right);
                btn_neighbor.setBackgroundResource(R.drawable.icon_neighbor_right);
                btn_service.setBackgroundResource(R.drawable.icon_service_right);
                //btn_mall.setBackgroundResource(R.drawable.icon_mall_select);
                btn_account.setBackgroundResource(R.drawable.icon_account_left);
                setLayoutItem(3);
                break;*//*
            case R.id.navigationbar_account:
                btn_home.setBackgroundResource ( R.drawable.icon_home_right );
                btn_neighbor.setBackgroundResource ( R.drawable.icon_neighbor_right );
                btn_service.setBackgroundResource ( R.drawable.icon_service_right );
                //btn_mall.setBackgroundResource(R.drawable.icon_mall_right);
                btn_account.setBackgroundResource ( R.drawable.icon_account_select );
                setLayoutItem ( 4 );
                break;
        }
    }*/

    public void hideFragment(FragmentTransaction transaction) {
        if (fragment_home != null) {
            transaction.hide ( fragment_home );
        }
        if (fragment_service != null) {
            transaction.hide ( fragment_service );
        }
        if (fragment_account != null) {
            transaction.hide ( fragment_account );
        }
        if (fragment_neighbor != null) {
            transaction.hide ( fragment_neighbor );
        }
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fragmentmanager = getSupportFragmentManager ();
        FragmentTransaction transaction = fragmentmanager.beginTransaction ();
        hideFragment ( transaction );
        switch (position) {
            case 0:
                if (fragment_home == null) {
                    fragment_home = new HomeFragment ();
                    transaction.add ( R.id.content, fragment_home );
                } else {
                    transaction.show ( fragment_home );
                }
                break;
            case 1:
                if (fragment_neighbor == null) {
                    fragment_neighbor = new NeighborFragment ();
                    transaction.add ( R.id.content, fragment_neighbor );
                } else {
                    transaction.show ( fragment_neighbor );
                }
                break;
            case 2:
                if (fragment_service == null) {
                    fragment_service = new ServiceFragment ();
                    transaction.add ( R.id.content, fragment_service );
                } else {
                    transaction.show ( fragment_service );
                }
                break;
            case 3:
                if (fragment_account == null) {
                    fragment_account = new AccountFragment ();
                    transaction.add ( R.id.content, fragment_account );
                } else {
                    transaction.show ( fragment_account );
                }
                break;
        }
        transaction.commit ();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

}

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
import com.baidu.mapapi.SDKInitializer;
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
    //private MallFragment fragment_mall;
    private AccountFragment fragment_account;
    private NeighborFragment fragment_neighbor;
    private BottomNavigationItem home = new BottomNavigationItem ( R.drawable.icon_home_select, "首页" );
    private BottomNavigationItem neighbor = new BottomNavigationItem ( R.drawable.icon_neighbor_select, "邻里" );
    private BottomNavigationItem service = new BottomNavigationItem ( R.drawable.icon_service_select, "服务" );
    private BottomNavigationItem account = new BottomNavigationItem ( R.drawable.icon_account_select, "我的" );

    FragmentManager fragmentmanager = getSupportFragmentManager ();
    FragmentTransaction transaction = fragmentmanager.beginTransaction ();

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
        bottomNavigationBar.addItem ( home )
                .addItem ( neighbor )
                .addItem ( service )
                .addItem ( account )
                .initialise ();
        bottomNavigationBar.setTabSelectedListener ( this );
    }


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
                neighbor.setInactiveIconResource ( R.drawable.icon_neighbor_left );
                service.setInactiveIconResource ( R.drawable.icon_service_left );
                account.setInactiveIconResource ( R.drawable.icon_account_left );
                if (fragment_home == null) {
                    fragment_home = new HomeFragment ();
                    transaction.add ( R.id.content, fragment_home );
                } else {
                    transaction.show ( fragment_home );
                }
                break;
            case 1:
                home.setInactiveIconResource ( R.drawable.icon_home_right );

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

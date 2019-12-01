package com.maureen.yishenghuo.activity;

import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.base.BaseActivity;
import com.maureen.yishenghuo.fragment.AccountFragment;
import com.maureen.yishenghuo.fragment.HomeFragment;
import com.maureen.yishenghuo.fragment.NeighborFragment;
import com.maureen.yishenghuo.fragment.ServiceFragment;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private long PressTime = 0;
    private HomeFragment mHomeFragment;
    private NeighborFragment mNeighborFragment;
    private ServiceFragment mServiceFragment;
    private AccountFragment mAccountFragment;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    /**
     * 双击返回键退出程序
     */
    @Override
    public void onBackPressed() {
        //获取第一次按键时间
        long NowTime = System.currentTimeMillis();
        if (NowTime - PressTime > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            //擦除第一次按钮
            PressTime = NowTime;
        } else {
            System.exit(0);
        }
    }

    @Override
    public void initView() {
        mHomeFragment = new HomeFragment();
        mNeighborFragment = new NeighborFragment();
        mServiceFragment = new ServiceFragment();
        mAccountFragment = new AccountFragment();
        BottomNavigationBar bottomNavigationBar = findViewById(R.id.main_navigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_home_select, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_neighbor_select, "邻里"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_service_select, "服务"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_account_select, "我的"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

        turnToFragment(mHomeFragment, R.id.content);
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                turnToFragment(mHomeFragment, R.id.content);
                break;
            case 1:
                turnToFragment(mNeighborFragment, R.id.content);
                break;
            case 2:
                turnToFragment(mServiceFragment, R.id.content);
                break;
            case 3:
                turnToFragment(mAccountFragment, R.id.content);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {
        switch (position) {
            case 0:
                hideCurrentFragment(mHomeFragment);
                break;
            case 1:
                hideCurrentFragment(mNeighborFragment);
                break;
            case 2:
                hideCurrentFragment(mServiceFragment);
                break;
            case 3:
                hideCurrentFragment(mAccountFragment);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

}

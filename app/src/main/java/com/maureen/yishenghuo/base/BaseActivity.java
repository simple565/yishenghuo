package com.maureen.yishenghuo.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * @Description
 * @Author Lianml
 * @Create 2019-11-30 15:52
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(getContentViewId());
        initView();
    }

    /**
     * 获取当前布局文件id
     *
     * @return 布局文件id
     */
    public abstract int getContentViewId();

    /**
     * 初始化布局
     */
    public abstract void initView();

    public void turnToFragment(Fragment toFragment, int containerID) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (toFragment != null) {
            if (!toFragment.isAdded()) {
                transaction.add(containerID, toFragment, toFragment.getClass().getSimpleName());
            } else {
                transaction.show(toFragment);
            }
        }
        transaction.commitAllowingStateLoss();

    }

    public void hideCurrentFragment(Fragment currentFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(currentFragment);
        transaction.commitAllowingStateLoss();
    }
}

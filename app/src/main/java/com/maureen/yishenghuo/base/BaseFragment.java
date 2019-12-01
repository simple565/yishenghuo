package com.maureen.yishenghuo.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.maureen.yishenghuo.ITurnToFragmentCallback;

/**
 * @Description
 * @Author Lianml
 * @Create 2019-11-30 18:41
 */
public abstract class BaseFragment extends Fragment implements ITurnToFragmentCallback {
    protected Context mContext;


    public abstract void onBackPressed();

    @SuppressLint("NewApi")
    @Override
    public void turnToFragment(Class<?> fromClass, Class<?> toClass, int containerViewId, Bundle bundle, boolean remove) {
        Fragment toFragment = null;
        Fragment fromFragment = null;
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        try {
            if (toClass != null) {
                toFragment = getChildFragmentManager().findFragmentByTag(toClass.getSimpleName());
                if (toFragment == null) {
                    toFragment = (Fragment) toClass.newInstance();
                    transaction.add(containerViewId, toFragment, toClass.getSimpleName());
                    if (bundle != null) {
                        toFragment.setArguments(bundle);
                    }
                }
            }
            if (fromClass != null) {
                fromFragment = getChildFragmentManager().findFragmentByTag(fromClass.getSimpleName());
                if (null != fromFragment) {
                    if (remove) {
                        transaction.remove(fromFragment);
                    } else {
                        transaction.hide(fromFragment);
                    }
                }
            }
            if (null != toFragment) {
                transaction.show(toFragment);
            }
            transaction.commitAllowingStateLoss();
        } catch (InstantiationException | IllegalAccessException | java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
}

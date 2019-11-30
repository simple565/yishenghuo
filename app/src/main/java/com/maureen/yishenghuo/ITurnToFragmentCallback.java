package com.maureen.yishenghuo;

import android.os.Bundle;

/**
 * @Description
 * @Author Lianml
 * @Create 2019/9/6
 */
public interface ITurnToFragmentCallback {
    /**
     * turnToFragment:(用于Fragment跳转到指定Fragment，并且可以指定container). <br/>
     *
     * @param fromClass       当前Fragment
     * @param toClass         目标Fragment
     * @param containerViewId Fragment容器
     * @param bundle          bundle
     * @param remove          是否从栈中移除当前Fragment
     */
    void turnToFragment(Class<?> fromClass, Class<?> toClass, int containerViewId, Bundle bundle, boolean remove);
}

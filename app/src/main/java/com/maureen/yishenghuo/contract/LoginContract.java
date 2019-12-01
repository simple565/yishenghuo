package com.maureen.yishenghuo.contract;

import com.maureen.yishenghuo.bean.UserBean;

/**
 * LoginActivity所需要的方法接口
 * 与view交互的方法
 * 获取用户账号密码及账号类型
 * 保存返回的用户ID
 * 显示登录结果
 */
public interface LoginContract {

    void saveData(UserBean userBean);

    void showLoginResult(UserBean userBean);

}

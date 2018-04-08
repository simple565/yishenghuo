package com.yishenghuo.yishenghuo.ui;

import com.yishenghuo.yishenghuo.bean.UserBean;

/**
 * LoginActivity所需要的方法接口
 * 与view交互的方法
 * 获取用户账号密码及账号类型
 * 保存返回的用户ID
 * 显示登录结果
 */
public interface LoginView {

    String getJsonBody(String name, String password);

    void saveData(UserBean userBean);

    void showLoginResult(UserBean userBean);

}

package com.yishenghuo.yishenghuo.ui;

import com.yishenghuo.yishenghuo.Model.bean.UserBean;
public interface RegisterView {

    //验证码倒计时60s
    void startCountDown();

    void saveData(UserBean userBean);

    void showResult(UserBean userBean);
}

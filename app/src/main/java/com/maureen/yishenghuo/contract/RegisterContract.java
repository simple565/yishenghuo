package com.maureen.yishenghuo.contract;

import com.maureen.yishenghuo.bean.UserBean;

public interface RegisterContract {

    //验证码倒计时60s
    void startCountDown();

    void saveData(UserBean userBean);

    void showResult(UserBean userBean);
}

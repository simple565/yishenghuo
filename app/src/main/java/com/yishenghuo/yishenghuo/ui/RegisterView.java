package com.yishenghuo.yishenghuo.ui;

import com.yishenghuo.yishenghuo.bean.UserBean;

public interface RegisterView {
    String getPhone();

    String getBody(String phone, String code);

    void saveData(UserBean userBean);

    void showResult(UserBean userBean);
}

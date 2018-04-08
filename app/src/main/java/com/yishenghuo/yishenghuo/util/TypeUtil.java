package com.yishenghuo.yishenghuo.util;

import java.util.regex.Pattern;

/**
 * 类型判断工具类
 */
public class TypeUtil {

    //验证手机号的正则表达式。
    private static final String REGEX_PHONE_NUMBER = "^1[3|4|5|7|8][0-9]\\\\d{4,8}$";

    //验证邮箱的正则表达式。
    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    //校验手机号
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_PHONE_NUMBER, mobile);
    }

    //校验邮箱
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

}

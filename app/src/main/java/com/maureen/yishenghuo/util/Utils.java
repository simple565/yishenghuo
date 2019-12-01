package com.maureen.yishenghuo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 工具类
 * @Author Lianml
 * @Create 2019-11-30 23:11
 */
public class Utils {

    public static String getDateString() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}


package com.maureen.yishenghuo.util;

/**
 * Created by Lian on 2018/2/22.
 */

public class NewsUtil {
    public static String getDetail(String string) {
        return string.replaceAll("<\\/p><p class=\\\"art_p\\\">", " ");
    }

}

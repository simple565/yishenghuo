package com.yishenghuo.yishenghuo.util;

import android.support.annotation.DrawableRes;

import com.yishenghuo.yishenghuo.R;

import java.lang.reflect.Field;

/**
 * Created by Lian on 2018/1/24.
 * 工具类
 */

public class WeatherUtil {
    //天气接口返回时间为2017-1-24 15：30截取后半时间即可
    public static String getTime(String string) {
        return string.substring ( string.indexOf ( " " ) );
    }

    //天气接口返回天气代码如晴-100,根据返回的代码使用图片
    public static @DrawableRes int getSmallIcon(String code) {
        String imageName = "ic_" + code;
        @DrawableRes int id = 0;
        Class drawable = R.drawable.class;
        try {
            Field field = drawable.getField ( imageName );
            id = field.getInt ( imageName );
        } catch (NoSuchFieldException e) {//如果没有在"mipmap"下找到imageName,将会返回0
            return 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        }
        return id;
    }


}

package com.maureen.yishenghuo.contract;

import android.content.Context;

/**
 * @Description 天气查询
 * @Author Lianml
 * @Create 2019-11-30 21:04
 */
public interface WeatherContract {
    interface View {
        Context getContext();

        void toastShowLong();

        void toastShowShort();

    }

    interface Presenter {

    }

    interface Model {

    }
}

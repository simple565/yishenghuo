package com.maureen.yishenghuo;

/**
 * 数据返回接口
 */
public interface DataCallBack<T> {
    void onSuccess(T data);
}

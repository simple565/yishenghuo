package com.maureen.yishenghuo.base;

/**
 * @Description 服务返回数据基础实体
 * @Author Lianml
 * @Create 2018/4/24
 */
public class BaseEntity {

    /**
     * code : 0
     * data :
     * msg :
     */

    private int code;
    private String data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

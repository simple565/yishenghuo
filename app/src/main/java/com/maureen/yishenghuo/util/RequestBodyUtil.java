package com.maureen.yishenghuo.util;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @Description 网络请求数据封装工具类
 * @Author Lianml
 * @Create 2018/2/16
 */
public class RequestBodyUtil {
    private static MediaType json = MediaType.parse("application/json; charset=utf-8");

    /**
     * 手机号
     *
     * @param phone
     * @return
     */
    public static RequestBody getPhone(String phone) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("phone", phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RequestBody.create(json, jsonObject.toString());
    }

    //

    /**
     * 登录所需数据
     *
     * @param username 账号
     * @param password 登录类型
     * @return
     */
    public static RequestBody getLoginBody(String username, String password) {

        JSONObject jsonObject = new JSONObject();
        try {
            if (TypeUtil.isEmail(username)) {
                jsonObject.put("login_type", "mail");
            } else {
                jsonObject.put("login_type", "phone");
            }
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RequestBody.create(json, jsonObject.toString());
    }

    public static RequestBody getVerifyBody(String phone, String code) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("phone", phone);
            jsonObject.put("code", code);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RequestBody.create(json, jsonObject.toString());
    }

    /**
     * @param lsprefix 车牌前缀
     * @param lsnum    车牌号
     * @param lstype   车辆类型
     * @param engineno 发动机号
     * @param frameno  车架号
     * @return
     */
    public static RequestBody getCarIllegal(String lsprefix, String lsnum, String lstype,
                                            String engineno, String frameno) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("lsprefix", lsprefix);
            jsonObject.put("lsnum", lsnum);
            jsonObject.put("lstype", lstype);
            jsonObject.put("engineno", engineno);
            jsonObject.put("frameno", frameno);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return RequestBody.create(json, jsonObject.toString());

    }

}

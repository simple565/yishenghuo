package com.yishenghuo.yishenghuo.util;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/*网络请求数据封装工具类*/
public class RequestBodyUtil {
    private static MediaType json = MediaType.parse ( "application/json; charset=utf-8" );

    //手机号
    public static RequestBody getPhone(String phone) {
        JSONObject jsonObject = new JSONObject ();
        try {
            jsonObject.put ( "phone", phone );
        } catch (JSONException e) {
            e.printStackTrace ();
        }
        return RequestBody.create ( json, jsonObject.toString () );
    }

    //登录所需数据 账号 密码 登录类型--phone/mail
    public static RequestBody getLoginBody(String username, String password) {

        JSONObject jsonObject = new JSONObject ();
        try {
            if (TypeUtil.isEmail ( username )) {
                jsonObject.put ( "login_type", "mail" );
            } else {
                jsonObject.put ( "login_type", "phone" );
            }
            jsonObject.put ( "username", username );
            jsonObject.put ( "password", password );
        } catch (JSONException e) {
            e.printStackTrace ();
        }
        return RequestBody.create ( json, jsonObject.toString () );
    }

    public static RequestBody getVerifyBody(String phone, String code) {
        JSONObject jsonObject = new JSONObject ();
        try {
            jsonObject.put ( "phone", phone );
            jsonObject.put ( "code", code );
        } catch (JSONException e) {
            e.printStackTrace ();
        }
        return RequestBody.create ( json, jsonObject.toString () );
    }

}

package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yishenghuo.yishenghuo.Prensenter.LoginPresenter;
import com.yishenghuo.yishenghuo.ui.LoginView;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.bean.UserBean;
import com.yishenghuo.yishenghuo.util.SharedPreferencesUtils;
import com.yishenghuo.yishenghuo.util.TypeUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText edt_username, edt_password;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        autoLogin ();
        iniView ();

    }

    private void iniView() {
        mLoginPresenter = new LoginPresenter ( this );
        edt_username = findViewById ( R.id.login_name );
        edt_password = findViewById ( R.id.login_password );
        final Button btn_login = findViewById ( R.id.login_btn_login );
        btn_login.setOnClickListener ( new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                String username = edt_username.getText ().toString ();
                String password = edt_password.getText ().toString ();
                if (username.isEmpty () || password.isEmpty ()) {
                    Toast.makeText ( LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT ).show ();
                } else {
                    mLoginPresenter.login ( getJsonBody ( username, password ) );
                }
            }
        } );

        TextView textView = findViewById ( R.id.login_start_register );
        textView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( LoginActivity.this, RegisterActivity.class ) );
            }
        } );
    }

    public void autoLogin() {
        if (!SharedPreferencesUtils.getParam ( this, "userID" ).isEmpty ()) {
            startActivity ( new Intent ( LoginActivity.this, MainActivity.class ) );
        }
    }

    //判断用户账户类型
    public String getLoginType(String username) {

        String type = "phone";
        if (TypeUtil.isEmail ( username )) {
            type = "phone";
        } else if (TypeUtil.isMobile ( username )) {
            type = "mail";
        }
        return type;
    }

    //将账号密码登陆类型转为json格式
    @Override
    public String getJsonBody(String username, String password) {
        JSONObject object = new JSONObject ();
        try {
            object.put ( "login_type", getLoginType ( username ) );
            object.put ( "username", username );
            object.put ( "password", password );
        } catch (JSONException e) {
            e.printStackTrace ();
        }
        Log.e ( "测试", object.toString () );
        return object.toString ();
    }

    @Override
    public void showLoginResult(UserBean userBean) {
        switch (userBean.getCode ()) {
            case 0:
                startActivity ( new Intent ( LoginActivity.this, MainActivity.class ) );
                break;
            case 1:
                Toast.makeText ( this, "用户名或密码错误", Toast.LENGTH_SHORT ).show ();
                break;
            case 2:
                Toast.makeText ( this, "用户名不存在", Toast.LENGTH_SHORT ).show ();
                break;
            default:
                Toast.makeText ( this, "登录失败", Toast.LENGTH_SHORT ).show ();
                break;
        }

    }

    //判断是否登录成功，是则保存数据
    @Override
    public void saveData(UserBean userBean) {

        if (userBean.getCode () == 0) {
            SharedPreferencesUtils.setParam ( this, "userID", userBean.getData ().getUser_id () );
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        if (mLoginPresenter != null) {
            mLoginPresenter.unSubscription ();
        }
    }
}

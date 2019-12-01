package com.maureen.yishenghuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.maureen.yishenghuo.contract.LoginContract;
import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.bean.UserBean;
import com.maureen.yishenghuo.presenter.LoginPresenter;
import com.maureen.yishenghuo.util.RequestBodyUtil;
import com.maureen.yishenghuo.util.SharedPreferencesUtils;

public class LoginActivity extends AppCompatActivity implements LoginContract {
    private EditText edt_username, edt_password;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        autoLogin();
        iniView();

    }

    private void iniView() {
        mLoginPresenter = new LoginPresenter(this);
        edt_username = findViewById(R.id.login_name);
        edt_password = findViewById(R.id.login_password);
        final Button btn_login = findViewById(R.id.login_btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    mLoginPresenter.login(RequestBodyUtil.getLoginBody(username, password));
                }
            }
        });

        TextView textView = findViewById(R.id.login_start_register);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    public void autoLogin() {
        if (!SharedPreferencesUtils.getParam(this, "userID").isEmpty()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }
    }

    @Override
    public void showLoginResult(UserBean userBean) {
        switch (userBean.getCode()) {
            case 0:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case 1:
                Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "用户名不存在", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    //判断是否登录成功，是则保存数据
    @Override
    public void saveData(UserBean userBean) {

        if (userBean.getCode() == 0) {
            SharedPreferencesUtils.setParam(this, "userID", userBean.getData().getUser_id());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLoginPresenter != null) {
            // mLoginPresenter.unSubscription ();
        }
    }
}

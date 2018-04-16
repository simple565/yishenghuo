package com.yishenghuo.yishenghuo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yishenghuo.yishenghuo.Prensenter.RegisterPresenter;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.Model.bean.UserBean;
import com.yishenghuo.yishenghuo.ui.RegisterView;
import com.yishenghuo.yishenghuo.util.SharedPreferencesUtils;

public class RegisterActivity extends AppCompatActivity implements RegisterView {
    private RegisterPresenter mRegisterPresenter;
    private EditText edt_username, edt_password, edt_password_again, edt_verifyceod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );
        iniView ();
    }

    private void iniView() {
        mRegisterPresenter = new RegisterPresenter ( this );
        ImageButton btn_back = findViewById ( R.id.register_btn_back );
        btn_back.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                finish ();
            }
        } );
        edt_username = findViewById ( R.id.register_name );
        edt_password = findViewById ( R.id.register_password );
        edt_password_again = findViewById ( R.id.register_password_again );
        edt_password_again.setOnFocusChangeListener ( new View.OnFocusChangeListener () {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    checkPassword ( edt_password.getText ().toString (), edt_password_again.getText ().toString () );
                }
            }
        } );
        Button btn_code = findViewById ( R.id.register_btn_getVerification );
        btn_code.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String username = edt_username.getText ().toString ();
                mRegisterPresenter.getVerifyCode ( username );
            }
        } );
        edt_verifyceod = findViewById ( R.id.register_verification );
        Button btn_register = findViewById ( R.id.register_btn_register );
        btn_register.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String phone = edt_username.getText ().toString ();
                String code = edt_verifyceod.getText ().toString ();
                String password = edt_password.getText ().toString ();
                mRegisterPresenter.register ( phone, code, password );
            }
        } );

    }

    //检测两次输入的密码是否相同
    private void checkPassword(String first, String second) {
        if (!first.equals ( second )) {
            Toast.makeText ( RegisterActivity.this, "两次输入不一致", Toast.LENGTH_SHORT ).show ();
        }
    }

    @Override
    public void startCountDown() {

    }

    @Override
    public void saveData(UserBean userBean) {
        if (userBean.getCode () == 0) {
            SharedPreferencesUtils.setParam ( this, "userID", userBean.getData ().getUser_id () );
        }
    }

    @Override
    public void showResult(UserBean userBean) {
        if (!userBean.getMsg ().isEmpty ()) {
            Toast.makeText ( this, userBean.getMsg (), Toast.LENGTH_SHORT ).show ();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        mRegisterPresenter.unSubscription ();
    }
}

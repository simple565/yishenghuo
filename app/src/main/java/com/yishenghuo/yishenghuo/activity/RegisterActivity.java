package com.yishenghuo.yishenghuo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yishenghuo.yishenghuo.Prensenter.RegisterPresenter;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.bean.UserBean;
import com.yishenghuo.yishenghuo.ui.RegisterView;
import com.yishenghuo.yishenghuo.ui.TitleBar;

import org.json.JSONException;
import org.json.JSONObject;

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
                mRegisterPresenter.getVerifyCode ( getPhone () );
            }
        } );
        edt_verifyceod = findViewById ( R.id.register_verification );
        Button btn_register = findViewById ( R.id.register_btn_register );
        btn_register.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String phone = edt_username.getText ().toString ();
                String code = edt_verifyceod.getText ().toString ();
                mRegisterPresenter.register ( getBody ( phone, code ) );
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
    public String getPhone() {
        JSONObject jsonObject = new JSONObject ();
        try {
            jsonObject.put ( "phone", "18850174468" );//18959261763
        } catch (JSONException e) {
            e.printStackTrace ();
        }
        Log.e ( "测试", "getPhone: " + jsonObject.toString () );
        return jsonObject.toString ();
    }

    @Override
    public String getBody(String phone, String code) {
        JSONObject jsonObject = new JSONObject ();
        try {
            jsonObject.put ( "phone", "18850174468" );//18959261763
            jsonObject.put ( "code", code);
        } catch (JSONException e) {
            e.printStackTrace ();
        }
        return jsonObject.toString ();
    }

    @Override
    public void saveData(UserBean userBean) {

    }

    @Override
    public void showResult(UserBean userBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        mRegisterPresenter.unSubscription ();
    }
}

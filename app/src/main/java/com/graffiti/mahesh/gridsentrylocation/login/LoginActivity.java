package com.graffiti.mahesh.gridsentrylocation.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.graffiti.mahesh.gridsentrylocation.R;
import com.graffiti.mahesh.gridsentrylocation.SplashPageActivity;
import com.graffiti.mahesh.gridsentrylocation.global.BaseActivity;
import com.graffiti.mahesh.gridsentrylocation.global.MessageConstants;
import com.graffiti.mahesh.gridsentrylocation.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @NonNull
    @BindView(R.id.edit_userEmail)
    EditText editTextUserEmail;
    @NonNull
    @BindView(R.id.edit_userPassword)
    EditText editTextUserPassword;
    @NonNull
    @BindView(R.id.btnLogin)
    Button buttonLogin;
    @NonNull
    @BindView(R.id.textForgotPassword)
    TextView textViewForgotPassword;
    @NonNull
    @BindView(R.id.rootView)
    RelativeLayout rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
    //log in
    @NonNull
    @OnClick(R.id.btnLogin)
    public void logIn()
    {

        Intent i=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(i);
//      String user_name=editTextUserPassword.getText().toString();
//      String password=editTextUserPassword.getText().toString();
//      if (!user_name.equals(null)&&!password.equals(null))
//      {
//          if (isConnectingToInternet(getApplicationContext()))
//          {
//
//          }
//          else
//          {
//              showSnakBar(rootView, MessageConstants.NO_INTERNET);
//          }
//      }
    }
// forgot passsword
    @NonNull
    @OnClick(R.id.textForgotPassword)
    public void forgotPassword()
    {

    }
}

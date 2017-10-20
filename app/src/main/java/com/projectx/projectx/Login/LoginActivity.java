package com.projectx.projectx.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectx.projectx.Model.LoginRequest;
import com.projectx.projectx.Model.LoginResponse;
import com.projectx.projectx.R;
import com.projectx.projectx.Signup.SignupActivity;
import com.projectx.projectx.Utils.ApiClient;
import com.projectx.projectx.Utils.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnSignup;
    private EditText edtMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.loginBtnCommit);
        btnSignup = (Button) findViewById(R.id.signUpBtnCommit);
        edtMobile = (EditText) findViewById(R.id.mobileEditText);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doUserLogin();
            }
        });
    }

    private void doUserLogin() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUser_mobile(edtMobile.getText().toString());

        Call<LoginResponse> userLogin = apiService.doLogin(loginRequest);
        userLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d("login Response", String.valueOf(response));

                LoginResponse loginResponse = response.body();

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}

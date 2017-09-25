package com.projectx.projectx.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectx.projectx.Model.LoginModel;
import com.projectx.projectx.R;
import com.projectx.projectx.Signup.SignupActivity;
import com.projectx.projectx.Utils.ApiClient;
import com.projectx.projectx.Utils.ApiInterface;

import org.json.JSONException;
import org.json.JSONObject;

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

        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("user_mobile", edtMobile.getText().toString());

            Call<LoginModel> userLogin = apiService.doLogin(paramObject.toString());
            userLogin.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

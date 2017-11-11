package com.projectx.projectx.Signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projectx.projectx.Config.ProjectXPref;
import com.projectx.projectx.Login.LoginActivity;
import com.projectx.projectx.Model.SignupRequest;
import com.projectx.projectx.Model.SignupResponse;
import com.projectx.projectx.R;
import com.projectx.projectx.Utils.ApiClient;
import com.projectx.projectx.Utils.ApiInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajith E R on 21/10/17.
 * @brief Application Signup OTP Activity
 */

public class SignupOtp extends AppCompatActivity {
    private Button pxlBack, pxlFinish;
    private EditText pxlOtpConfirm;
    private ProjectXPref prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_otp);
        prefManager = new ProjectXPref(getApplicationContext());
        pxlBack = (Button) findViewById(R.id.btn_back);
        pxlFinish = (Button) findViewById(R.id.btn_finish);

        pxlOtpConfirm = (EditText) findViewById(R.id.editTextUserOtp);

        pxlFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkotpcorrect();
            }
        });
        pxlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupOtp.this, SignupMobileConfirm.class));
            }
        });
    }

    private void checkotpcorrect() {
        if(prefManager.getUserMobileConfirmOtp().equals(pxlOtpConfirm.getText().toString())){
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            HashMap<String, String> user = prefManager.getSignupUserDetails();

            SignupRequest signupRequest = new SignupRequest();
            signupRequest.setUser_name(user.get(ProjectXPref.KEY_USER_NAME));
            signupRequest.setUser_mobile(user.get(ProjectXPref.KEY_USER_MOBILE));
            signupRequest.setUser_sex(user.get(ProjectXPref.KEY_USER_SEX));
            signupRequest.setUser_dob(user.get(ProjectXPref.KEY_USER_DOB));
            signupRequest.setUser_location(user.get(ProjectXPref.KEY_USER_LOCATION));
            signupRequest.setUser_sex_interested(user.get(ProjectXPref.KEY_USER_INTERESTED_SEX));
            signupRequest.setUser_sex_max(user.get(ProjectXPref.KEY_USER_INTERESTED_SEX_MAX));
            signupRequest.setUser_sex_min(user.get(ProjectXPref.KEY_USER_INTERESTED_SEX_MIN));
            signupRequest.setUser_address(user.get(ProjectXPref.KEY_USER_ADDRESS));

            Call<SignupResponse> signupCall = apiService.doSignUp(signupRequest);
            signupCall.enqueue(new Callback<SignupResponse>() {
                @Override
                public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {

                    SignupResponse signupResponse = response.body();

                    if (signupResponse.getSuccess().equals("true")) {
                        startActivity(new Intent(SignupOtp.this, LoginActivity.class));
                    } else {
                        Toast.makeText(SignupOtp.this, "Ooops Something went wrong! try again", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<SignupResponse> call, Throwable t) {

                }
            });
        }else{
            Toast.makeText(SignupOtp.this, "Wrong OTP! try again", Toast.LENGTH_LONG).show();
        }
    }
}

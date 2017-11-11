package com.projectx.projectx.Signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projectx.projectx.Config.ProjectXPref;
import com.projectx.projectx.Model.OtpRequest;
import com.projectx.projectx.Model.OtpResponse;
import com.projectx.projectx.R;
import com.projectx.projectx.Utils.ApiClient;
import com.projectx.projectx.Utils.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajith E R on 21/10/17.
 * @brief Application Signup Mobile Number Activity
 */

public class SignupMobileConfirm extends AppCompatActivity {
    private Button pxlBack, pxlNext;
    private EditText pxlUserRegMobile;
    private ProjectXPref prefManager;
    private String userMobileNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_mobile_confirm);
        prefManager = new ProjectXPref(this);
        pxlBack = (Button) findViewById(R.id.btn_back);
        pxlNext = (Button) findViewById(R.id.btn_next);

        pxlUserRegMobile = (EditText) findViewById(R.id.editTextUserMobile);
        pxlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOtpToMobileNumber();
            }
        });
        pxlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupMobileConfirm.this, SignupSexInterest.class));
            }
        });
    }

    private void sendOtpToMobileNumber() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        OtpRequest otpRequest = new OtpRequest();
        String type = "verify-number";
        userMobileNumber = pxlUserRegMobile.getText().toString();
        otpRequest.setType(type);
        otpRequest.setMobile_number(userMobileNumber);


        Call<OtpResponse> otpCall = apiService.otp(otpRequest);
        otpCall.enqueue(new Callback<OtpResponse>() {
            @Override
            public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {

                OtpResponse otpResponse = response.body();

                if (otpResponse.getSuccess().equals("true")) {
                    prefManager.setUserMobileVerified(userMobileNumber);
                    prefManager.setUserMobileConfirmOtp(otpResponse.getOtp());
                    startActivity(new Intent(SignupMobileConfirm.this, SignupOtp.class));
                } else {
                    Toast.makeText(SignupMobileConfirm.this, "Ooops Something went wrong! try again", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<OtpResponse> call, Throwable t) {

            }
        });

    }
}

package com.projectx.projectx.Signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.projectx.projectx.Model.OtpRequest;
import com.projectx.projectx.Model.OtpResponse;
import com.projectx.projectx.R;

public class SignupOtp extends AppCompatActivity {
    private Button pxlBack, pxlFinish;
    private EditText pxlOtpConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_otp);

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
        if (pxlOtpConfirm.getText().toString().equals(OtpResponse.getOtp())){
            startActivity(new Intent(SignupOtp.this, SignupActivity.class));
        }else {
            Toast.makeText(SignupOtp.this, "Wrong OTP", Toast.LENGTH_LONG).show();
        }
    }
}

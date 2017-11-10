package com.projectx.projectx.Signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projectx.projectx.R;

public class SignupSexInterest extends AppCompatActivity {

    private Button pxlBack, pxlNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_sex_interest);
        pxlBack = (Button) findViewById(R.id.btn_back);
        pxlNext = (Button) findViewById(R.id.btn_next);

        pxlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupSexInterest.this, SignupMobileConfirm.class));
            }
        });
        pxlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupSexInterest.this, SignupActivity.class));
            }
        });
    }
}

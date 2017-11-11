package com.projectx.projectx.Signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projectx.projectx.Config.ProjectXPref;
import com.projectx.projectx.R;

public class SignupSexInterest extends AppCompatActivity {
    private ProjectXPref prefManager;
    private EditText userSexInterest, userSexMax, userSexMin;
    private Button pxlBack, pxlNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_sex_interest);

        prefManager = new ProjectXPref(this);

        pxlBack = (Button) findViewById(R.id.btn_back);
        pxlNext = (Button) findViewById(R.id.btn_next);

        userSexInterest = (EditText) findViewById(R.id.editTextSex);
        userSexMax = (EditText) findViewById(R.id.editMaxSex);
        userSexMin = (EditText) findViewById(R.id.editMinSex);

        pxlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.setUserSignupSexInfo(userSexInterest.getText().toString(),userSexMax.getText().toString(),userSexMin.getText().toString());
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

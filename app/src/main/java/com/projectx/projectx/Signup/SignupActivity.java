package com.projectx.projectx.Signup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.projectx.projectx.Config.ProjectXPref;
import com.projectx.projectx.IntroSlider.WelcomeSlider;
import com.projectx.projectx.Login.LoginActivity;
import com.projectx.projectx.R;

/**
 * Created by Ajith E R on 21/10/17.
 * @brief Application Signup User info Page Activity
 */

public class SignupActivity extends AppCompatActivity {
    private ProjectXPref prefManager;
    private EditText userName, userSex, userDOB, userLocation, userAddress;
    private Button pxlCancel,pxlNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        prefManager = new ProjectXPref(this);

        pxlCancel = (Button) findViewById(R.id.btn_cancel);
        pxlNext = (Button) findViewById(R.id.btn_next);

        userName = (EditText) findViewById(R.id.editTextUsername);
        userSex = (EditText) findViewById(R.id.editTextUserSex);
        userDOB = (EditText) findViewById(R.id.editTextUserDob);
        userLocation = (EditText) findViewById(R.id.editTextUserLocation);
        userAddress = (EditText) findViewById(R.id.editTextUserAddress);

        pxlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prefManager.setUserSignupInfo(userSex.getText().toString(),userDOB.getText().toString(),userLocation.getText().toString(),userAddress.getText().toString(), userName.getText().toString());
                startActivity(new Intent(SignupActivity.this, SignupSexInterest.class));
            }
        });
        pxlCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }
}


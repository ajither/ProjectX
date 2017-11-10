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

public class SignupActivity extends AppCompatActivity {
    private ProjectXPref prefManager;
    private EditText userName;
    private Button pxlCancel,pxlNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        pxlCancel = (Button) findViewById(R.id.btn_cancel);
        pxlNext = (Button) findViewById(R.id.btn_next);

        pxlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


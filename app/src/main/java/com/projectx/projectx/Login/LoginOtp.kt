package com.projectx.projectx.Login

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.projectx.projectx.Config.ProjectXPref
import com.projectx.projectx.MainActivity
import com.projectx.projectx.R
import com.projectx.projectx.Signup.SignupActivity

import kotlinx.android.synthetic.main.activity_login_otp.*
/**
 * Created by Ajith E R on 11/11/17.
 * @brief All Login OTP Confirm
 */
class LoginOtp : AppCompatActivity() {
    private var prefManager: ProjectXPref? = null
    private var userLoginOtp : EditText? = null;
    private var btnLoginOtp: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_otp)
        setSupportActionBar(toolbar)

        prefManager = ProjectXPref(this)

        userLoginOtp = findViewById<EditText>(R.id.editTextUserLoginOtp)
        btnLoginOtp = findViewById<Button>(R.id.loginBtnOtpCommit)

        btnLoginOtp!!.setOnClickListener { doUserLoginWithOtp() }

    }

    private fun doUserLoginWithOtp() {
       if (prefManager!!.getUserLoginOtp().equals(userLoginOtp!!.text.toString())){
           prefManager!!.setLogin(false);
           startActivity(Intent(this@LoginOtp, MainActivity::class.java))
       }else{
           Toast.makeText(this, "Wrong Otp Provided", Toast.LENGTH_LONG).show();
       }
    }

}

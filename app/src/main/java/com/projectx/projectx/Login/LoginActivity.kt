package com.projectx.projectx.Login

import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.projectx.projectx.Config.ProjectXPref
import com.projectx.projectx.MainActivity

import com.projectx.projectx.Model.LoginRequest
import com.projectx.projectx.Model.LoginResponse
import com.projectx.projectx.R
import com.projectx.projectx.Signup.SignupActivity
import com.projectx.projectx.Utils.ApiClient
import com.projectx.projectx.Utils.ApiInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**
 * Created by Ajith E R on 11/11/17.
 * @brief All Login Activity
 */

class LoginActivity : AppCompatActivity() {
    private var prefManager: ProjectXPref? = null
    private var btnLogin: Button? = null
    private var btnSignup: Button? = null
    private var edtMobile: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefManager = ProjectXPref(this)

        if (!prefManager!!.isLogin()){
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }

        btnLogin = findViewById(R.id.loginBtnCommit) as Button
        btnSignup = findViewById(R.id.signUpBtnCommit) as Button
        edtMobile = findViewById(R.id.mobileEditText) as EditText
        btnSignup!!.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
            finish()
        }

        btnLogin!!.setOnClickListener { doUserLogin() }
    }

    private fun doUserLogin() {
        val apiService = ApiClient.getClient().create<ApiInterface>(ApiInterface::class.java!!)

        val loginRequest = LoginRequest()
        loginRequest.user_mobile = edtMobile!!.text.toString()

        val userLogin = apiService.doLogin(loginRequest)
        userLogin.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.d("login Response", response.toString())

                val LoginResponse   = response.body()

                if (LoginResponse!!.getSuccess().equals("true")) {
                    prefManager!!.setUserLoginOtp(LoginResponse!!.otp)
                    startActivity(Intent(this@LoginActivity, LoginOtp::class.java))
                } else {
                    Toast.makeText(this@LoginActivity, LoginResponse!!.message, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }
        })
    }
}

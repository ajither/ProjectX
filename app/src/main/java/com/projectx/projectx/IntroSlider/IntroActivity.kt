package com.projectx.projectx.IntroSlider

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

import com.projectx.projectx.R

/**
 * Created by Ajith E R on 18/9/17.
 * @brief Application Intro Flas Screen
 */

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        Handler().postDelayed({
            val i = Intent(this@IntroActivity, WelcomeSlider::class.java)
            startActivity(i)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private val SPLASH_TIME_OUT = 3000
    }
}

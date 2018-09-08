package com.example.keronpola.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.RateThisApp


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this, LanChangeK::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {

        private val SPLASH_TIME_OUT = 3000
    }

    override fun onStart() {
        super.onStart()
        RateThisApp.onStart(this)
    }
    }



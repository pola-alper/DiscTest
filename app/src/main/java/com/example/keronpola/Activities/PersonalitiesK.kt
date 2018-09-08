package com.example.keronpola.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.App
import kotlinx.android.synthetic.main.activity_personalities.*

class PersonalitiesK : AppCompatActivity() {
    internal lateinit var app: App
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalities)
        app = application as App
        app.loadAd(adViewPer)




        personality_d.setOnClickListener {
            val window = Intent(this, ResultActivityDK::class.java)
            startActivity(window)
        }


        personality_i.setOnClickListener {
            val window = Intent(this, ResultActivityIK::class.java)
            startActivity(window)
        }


        personality_s.setOnClickListener {
            val window = Intent(this, ResultActivitySK::class.java)
            startActivity(window)
        }


        personality_c.setOnClickListener {
            val window = Intent(this, ResultActivityCK::class.java)
            startActivity(window)
        }

    }


}

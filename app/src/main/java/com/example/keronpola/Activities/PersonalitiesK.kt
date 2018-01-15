package com.example.keronpola.DiscTest.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kerojesus.DiscTest.R
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_personalities.*

class PersonalitiesK : AppCompatActivity() {

private lateinit var adRequest:AdRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalities)

       adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)



        personality_d.setOnClickListener {
            val window = Intent(this, ResultActivity_DK::class.java)
            startActivity(window)
        }


        personality_i.setOnClickListener {
            val window = Intent(this, ResultActivity_IK::class.java)
            startActivity(window)
        }


        personality_s.setOnClickListener {
            val window = Intent(this, ResultActivity_SK::class.java)
            startActivity(window)
        }


        personality_c.setOnClickListener {
            val window = Intent(this, ResultActivity_CK::class.java)
            startActivity(window)
        }
    }


}

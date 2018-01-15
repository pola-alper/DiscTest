package com.example.keronpola.DiscTest.Activities

import android.graphics.Color
import android.os.Bundle
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Adapter.PageAdapterD
import com.example.keronpola.DiscTest.Util.BaseActivityK
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_result_activity__d.*
import kotlinx.android.synthetic.main.content_result_activity__d.*

/**
* Created by pola on 11-Jan-18.
*/

class ResultActivity_DK : BaseActivityK() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activity__d)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)


        val mapager = PageAdapterD(supportFragmentManager, this)

        pager.adapter = mapager
        tab_strip.setTextColor(Color.WHITE)


    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
        // optional depending on your needs
    }


}

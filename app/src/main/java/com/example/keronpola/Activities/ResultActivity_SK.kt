package com.example.keronpola.DiscTest.Activities

import android.graphics.Color
import android.os.Bundle
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Adapter.PageAdapterS
import com.example.keronpola.DiscTest.Util.App
import com.example.keronpola.DiscTest.Util.BaseActivityK
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_result_activity__s.*
import kotlinx.android.synthetic.main.content_result_activity__s.*

class ResultActivity_SK : BaseActivityK() {

    private lateinit var mInterstitialAd: InterstitialAd

    internal lateinit var app: App
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activity__s)
        app = application as App
        app.loadAd(adViewS)
        mInterstitialAd = InterstitialAd(this)
        app.load(mInterstitialAd)

        val mapager = PageAdapterS(supportFragmentManager, this)

        pager.adapter = mapager
        tab_strip.setTextColor(Color.WHITE)
        mInterstitialAd.adListener = object: AdListener() {
            override fun onAdLoaded() {
                mInterstitialAd.show()
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                app.load(mInterstitialAd)
                // Code to be executed when an ad request fails.
            }

        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
        // optional depending on your needs
    }

}

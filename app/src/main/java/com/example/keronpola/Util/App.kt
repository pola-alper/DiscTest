package com.example.keronpola.DiscTest.Util

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.kerojesus.DiscTest.R
import com.google.android.gms.ads.*


class App : Application() {
    private var adView: AdView? = null
    private lateinit var mInterstitialAd: InterstitialAd
    private val TAG = "App"
    override fun onCreate() {
        // TODO Auto-generated method stub

        super.onCreate()

        adView = AdView(this)
        adView!!.adSize = AdSize.BANNER
        adView!!.adUnitId = resources.getString(R.string.banner_ad_unit_id)
        // Request for Ads
        val adRequest = AdRequest.Builder().build()

        // Load ads into Banner Ads
        adView!!.loadAd(adRequest)
        mInterstitialAd = InterstitialAd(this)
        load(mInterstitialAd)

    }
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManagerk.setLocale(base))
        Log.d(TAG, "attachBaseContext")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManagerk.setLocale(this)
        Log.d(TAG, "onConfigurationChanged: " + newConfig.locale.language)
    }

    fun loadAd(layAd: LinearLayout) {

        // Locate the Banner Ad in activity xml

        layAd.postDelayed({
            // TODO Auto-generated method stub
            if (adView!!.parent != null) {
                val tempVg = adView!!.parent as ViewGroup
                tempVg.removeView(adView)
            }

            layAd.addView(adView)
        }, 100)
    }
fun load(mInterstitialAd: InterstitialAd){
    MobileAds.initialize(this,
            "ca-app-pub-7864537676903385/1254576153")


    mInterstitialAd.adUnitId =
            "ca-app-pub-7864537676903385/1254576153"
    mInterstitialAd.loadAd(AdRequest.Builder().build())

}
}
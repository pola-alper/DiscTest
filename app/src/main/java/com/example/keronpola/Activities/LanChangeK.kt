package com.example.keronpola.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Activities.StartActivity
import com.example.keronpola.DiscTest.Util.App

import com.example.keronpola.DiscTest.Util.LocaleManagerk
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_lan.*


class LanChangeK : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    internal lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lan)
        app = application as App
        mInterstitialAd = InterstitialAd(this)
        app.load(mInterstitialAd)



        english.setOnClickListener {

                setNewLocale(LocaleManagerk.LANGUAGE_ENGLISH)



        }
        arabic.setOnClickListener {



                setNewLocale(LocaleManagerk.LANGUAGE_ARABIC)

        }
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

    private fun setNewLocale(language: String): Boolean {
        LocaleManagerk.setNewLocale(this, language)

        val i = Intent(this, StartActivity::class.java)
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))


        return true
    }


}

package com.example.keronpola.Activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.App
import com.example.keronpola.DiscTest.Util.BaseActivityK
import com.example.keronpola.DiscTest.Util.Logic
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_result_activity__d.*

/**
 * Created by pola on 11-Jan-18.
 */

class ResultActivityDK : BaseActivityK() {
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var logic: Logic
    internal lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activity__d)

        app = application as App
        app.loadAd(adView)
        mInterstitialAd = InterstitialAd(this)
        app.load(mInterstitialAd)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = resources.getString(R.string.personality_d)


        val das = resources.getStringArray(R.array.das)
        val daw = resources.getStringArray(R.array.daw)
        val dai = resources.getStringArray(R.array.dai)
        val dan = resources.getStringArray(R.array.dan)
        val dae = resources.getStringArray(R.array.dae)
        val dac = resources.getStringArray(R.array.dac)
        val daph = resources.getStringArray(R.array.daph)
        val dam = resources.getStringArray(R.array.dam)
        val damh = resources.getStringArray(R.array.damh)
        val dadh = resources.getStringArray(R.array.dadh)
        logic = Logic()

        logic.iterate(spd, das)

        logic.iterate(wpd, daw)

        logic.iterate(isd, dai)

        logic.iterate(nedd, dan)

        logic.iterate(aspd, dae)

        logic.iterate(htcd, dac)

        logic.iterate(htpd, daph)

        logic.iterate(htmd, damh)

        logic.iterate(htdd, dadh)

        logic.iterate(bod, dam)
        mInterstitialAd.adListener = object : AdListener() {
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_share -> {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,

                    resources.getString(R.string.tAb1d1) + "\n" + spd.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + wpd.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + isd.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + nedd.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + aspd.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + htcd.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + htpd.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + htmd.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + htdd.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + bod.text
                            + "\n" + "https://www.youtube.com/watch?v=" + resources.getText(R.string.dvideoresult))

            sendIntent.type = "text/plain"
            startActivity(sendIntent)
            true
        }


        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
        // optional depending on your needs
    }


}

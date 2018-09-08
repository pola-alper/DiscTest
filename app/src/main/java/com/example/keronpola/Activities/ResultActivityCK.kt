package com.example.keronpola.Activities

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.activity_result_activity__c.*

@SuppressLint("Registered")
class ResultActivityCK : BaseActivityK() {
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var logic: Logic
    internal lateinit var app: App
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activity__c)
        app = application as App
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = resources.getString(R.string.personality_c)
        app.loadAd(adView)
        mInterstitialAd = InterstitialAd(this)
        app.load(mInterstitialAd)
        val cas = resources.getStringArray(R.array.cas)
        val caw = resources.getStringArray(R.array.caw)
        val cai = resources.getStringArray(R.array.cai)
        val can = resources.getStringArray(R.array.can)
        val cae = resources.getStringArray(R.array.cae)
        val cac = resources.getStringArray(R.array.cac)
        val aph = resources.getStringArray(R.array.aph)
        val am = resources.getStringArray(R.array.am)
        val amh = resources.getStringArray(R.array.amh)
        val adh = resources.getStringArray(R.array.adh)
        logic = Logic()
        logic.iterate(spc, cas)

        logic.iterate(wpc, caw)

        logic.iterate(isc, cai)

        logic.iterate(nedc, can)

        logic.iterate(aspc, cae)

        logic.iterate(htcc, cac)

        logic.iterate(htpc, aph)

        logic.iterate(htmc, amh)

        logic.iterate(htdc, adh)

        logic.iterate(boc, am)

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

                    resources.getString(R.string.tAb1d1) + "\n" + spc.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + wpc.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + isc.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + nedc.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + aspc.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + htcc.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + htpc.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + htmc.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + htdc.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + boc.text
            )
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

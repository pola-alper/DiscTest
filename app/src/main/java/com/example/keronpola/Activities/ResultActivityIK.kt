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
import kotlinx.android.synthetic.main.activity_result_activity__i.*

class ResultActivityIK : BaseActivityK() {

    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var logic: Logic
    internal lateinit var app: App
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activity__i)
        app = application as App
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = resources.getString(R.string.personality_i)
        app.loadAd(adView)
        mInterstitialAd = InterstitialAd(this)
        app.load(mInterstitialAd)


        val ias = resources.getStringArray(R.array.ias)
        val iaw = resources.getStringArray(R.array.iaw)
        val iai = resources.getStringArray(R.array.iai)
        val ian = resources.getStringArray(R.array.ian)
        val iae = resources.getStringArray(R.array.iae)
        val iac = resources.getStringArray(R.array.iac)
        val iaph = resources.getStringArray(R.array.iaph)
        val iamh = resources.getStringArray(R.array.iamh)
        val iadh = resources.getStringArray(R.array.iadh)
        val iam = resources.getStringArray(R.array.iam)
        logic = Logic()

        logic.iterate(spi, ias)

        logic.iterate(wpi, iaw)

        logic.iterate(isi, iai)

        logic.iterate(nedi, ian)

        logic.iterate(aspi, iae)

        logic.iterate(htci, iac)

        logic.iterate(htpi, iaph)

        logic.iterate(htmi, iamh)

        logic.iterate(htdi, iadh)

        logic.iterate(boi, iam)
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

                    resources.getString(R.string.tAb1d1) + "\n" + spi.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + wpi.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + isi.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + nedi.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + aspi.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + htci.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + htpi.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + htmi.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + htdi.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + boi.text
                            + "\n" + "https://www.youtube.com/watch?v=" + resources.getText(R.string.ivideoresult))
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
            true
        }


        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

}

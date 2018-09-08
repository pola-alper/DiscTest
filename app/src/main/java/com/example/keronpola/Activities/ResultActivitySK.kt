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
import kotlinx.android.synthetic.main.activity_result_activity__s.*

class ResultActivitySK : BaseActivityK() {
    private lateinit var logic: Logic
    private lateinit var mInterstitialAd: InterstitialAd
    internal lateinit var app: App
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activity__s)
        app = application as App
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = resources.getString(R.string.personality_s)
        app.loadAd(adView)
        mInterstitialAd = InterstitialAd(this)
        app.load(mInterstitialAd)

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
        logic = Logic()

        val sas = resources.getStringArray(R.array.sas)

        val saw = resources.getStringArray(R.array.saw)

        val sai = resources.getStringArray(R.array.sai)

        val san = resources.getStringArray(R.array.san)

        val sae = resources.getStringArray(R.array.sae)

        val sac = resources.getStringArray(R.array.sac)

        val saph = resources.getStringArray(R.array.saph)

        val samh = resources.getStringArray(R.array.samh)

        val sadh = resources.getStringArray(R.array.sadh)

        val sam = resources.getStringArray(R.array.sam)

        logic.iterate(sps, sas)

        logic.iterate(wps, saw)

        logic.iterate(iss, sai)

        logic.iterate(neds, san)

        logic.iterate(asps, sae)

        logic.iterate(htcs, sac)

        logic.iterate(htps, saph)

        logic.iterate(htms, samh)

        logic.iterate(htds, sadh)

        logic.iterate(bos, sam)
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

                    resources.getString(R.string.tAb1d1) + "\n" + sps.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + wps.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + iss.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + neds.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + asps.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + htcs.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + htps.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + htms.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + htds.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + bos.text
                            + "\n" + "https://www.youtube.com/watch?v=" + resources.getText(R.string.svideoresult))

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

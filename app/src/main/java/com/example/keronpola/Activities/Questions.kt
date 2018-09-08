package com.example.keronpola.DiscTest.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.App
import com.example.keronpola.DiscTest.Util.BaseActivityK
import com.example.keronpola.DiscTest.Util.Logic
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import kotlinx.android.synthetic.main.activity_question.*

class Questions : BaseActivityK() {
    private var d = 0
    private var i = 0
    private var s = 0
    private var c = 0
    private var doubleBackToExitPressedOnce = false
    private var d_loop = 0
    private var i_loop = 0
    private var s_loop = 0
    private var c_loop = 0
    private var counter = 0
    private var logic: Logic? = null
    private lateinit var d_string: Array<String>
    private lateinit var i_string: Array<String>
    private lateinit var s_string: Array<String>
    private lateinit var c_string: Array<String>
    private lateinit var count_string: Array<String>

    internal lateinit var app: App
    private lateinit var mInterstitialAd: InterstitialAd

    @SuppressLint("SetTextI18n")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        app = application as App
        app.loadAd(adViewQ)
        mInterstitialAd = InterstitialAd(this)
        app.load(mInterstitialAd)
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }

        logic = Logic()
        d_string = resources.getStringArray(R.array.q_d)
        i_string = resources.getStringArray(R.array.q_i)
        s_string = resources.getStringArray(R.array.q_s)
        c_string = resources.getStringArray(R.array.q_c)
        count_string = resources.getStringArray(R.array.counter)

        button_d!!.text = getString(R.string.d1)
        button_i!!.text = getString(R.string.i1)
        button_s!!.text = getString(R.string.s1)
        button_c!!.text = getString(R.string.c1)


        count!!.text = "1/24"



        button_d!!.setOnClickListener {
            iterate()

            d++
        }


        button_i!!.setOnClickListener {
            iterate()


            i++
        }


        button_s!!.setOnClickListener {
            iterate()

            s++
        }

        button_c!!.setOnClickListener {
            iterate()


            c++
        }

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

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finish()

            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()


        Handler().postDelayed({ doubleBackToExitPressedOnce = true }, 0)


    }

    @SuppressLint("SetTextI18n")
    private fun iterate() {
        if (d_loop < d_string.size - 1 && i_loop < i_string.size - 1 && s_loop < s_string.size - 1 && c_loop < c_string.size - 1 && counter < i_string.size - 1) {
            d_loop++
            i_loop++
            s_loop++
            c_loop++
            counter++

        } else {

            logic!!.send(d, i, s, c, this)

        }
        button_d!!.text = ""
        button_d!!.text = button_d!!.text.toString() + d_string[d_loop]
        button_i!!.text = ""
        button_i!!.text = button_i!!.text.toString() + i_string[i_loop]
        button_s!!.text = ""
        button_s!!.text = button_s!!.text.toString() + s_string[s_loop]
        button_c!!.text = ""
        button_c!!.text = button_c!!.text.toString() + c_string[c_loop]
        count!!.text = ""
        count!!.text = count_string[counter] + "/24"

    }


}

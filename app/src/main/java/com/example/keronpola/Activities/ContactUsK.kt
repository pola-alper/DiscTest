package com.example.keronpola.DiscTest.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.BaseActivityK
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_contact__us.*

class ContactUsK : BaseActivityK() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact__us)
        val addrequst: AdRequest? = AdRequest.Builder().build()
        adView.loadAd(addrequst)
        setSupportActionBar(toolbar)
        setuptoolbar()


        facebook.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/DISC.analysis/"))
            startActivity(i)
        }
        gmail.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "message/rfc822"

            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("\n" + "disc.analysis@gmail.com"))
            i.putExtra(Intent.EXTRA_SUBJECT, "DISC_Test")
            i.putExtra(Intent.EXTRA_TEXT, "your feedback about owr test")
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (x: android.content.ActivityNotFoundException) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
        youtube.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCAKdfVYGGb4OIZNGYYZPZ5A/"))
            startActivity(i)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun setuptoolbar() {
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
}

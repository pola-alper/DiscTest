package com.example.keronpola.DiscTest.Activities

import android.os.Bundle
import android.view.MenuItem
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.App
import com.example.keronpola.DiscTest.Util.BaseActivityK
import kotlinx.android.synthetic.main.activity_about_k.*

class AboutActivityK : BaseActivityK() {
    internal lateinit var app: App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_k)
        app = application as App
        app.loadAd(adViewabout)
        setSupportActionBar(toolbar)
        setupToolBar()

    }

    private fun setupToolBar() {
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

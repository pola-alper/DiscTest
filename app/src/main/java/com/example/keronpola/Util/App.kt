package com.example.keronpola.DiscTest.Util

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.util.Log

class App : Application() {

    private val TAG = "App"

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManagerk.setLocale(base))
        Log.d(TAG, "attachBaseContext")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManagerk.setLocale(this)
        Log.d(TAG, "onConfigurationChanged: " + newConfig.locale.language)
    }
}
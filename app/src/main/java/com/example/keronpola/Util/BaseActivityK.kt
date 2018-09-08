package com.example.keronpola.DiscTest.Util

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager.GET_META_DATA
import android.content.pm.PackageManager.NameNotFoundException
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import com.example.kerojesus.DiscTest.R


import com.example.keronpola.DiscTest.Util.LocaleManagerk.LANGUAGE_ARABIC
import com.example.keronpola.DiscTest.Util.LocaleManagerk.LANGUAGE_ENGLISH
import java.lang.ref.WeakReference
import java.util.*


abstract class BaseActivityK : AppCompatActivity() {

    private val topLevelResources: Resources
        get() {
            try {
                return packageManager.getResourcesForApplication(applicationInfo)
            } catch (e: NameNotFoundException) {
                throw RuntimeException(e)
            }

        }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManagerk.setLocale(base))
        Log.d(TAG, "attachBaseContext")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        resetTitles()
    }

    private fun resetTitles() {
        try {
            val info = packageManager.getActivityInfo(componentName, GET_META_DATA)
            if (info.labelRes != 0) {
                setTitle(info.labelRes)
            }
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        showResourcesInfo()
        showTitleCache()
    }

    private fun showResourcesInfo() {
        val topLevelRes = topLevelResources

        val appRes = application.resources


        val actRes = resources

        val defLanguage = Locale.getDefault().language

    }

    @SuppressLint("SetTextI18n")
    private fun updateInfo(title: String, tv: TextView, res: Resources) {
        val l = LocaleManagerk.getLocale(res)
        tv.text = title + Utility.hexString(res) + String.format(" - %s", l.language)
        val icon = getLanguageDrawable(l.language)
        tv.setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null)
    }

    private fun showTitleCache() {
        val o = Utility.getPrivateField("android.app.ApplicationPackageManager", "sStringCache", null)
        val cache = o as Map<*, WeakReference<CharSequence>> ?: return

        val builder = StringBuilder("Cache:").append("\n")
        for ((_, value) in cache) {
            val title = value.get()
            if (title != null) {
                builder.append(title).append("\n")
            }
        }

    }

    private fun getLanguageDrawable(language: String): Drawable? {
        when (language) {
            LANGUAGE_ENGLISH -> return ContextCompat.getDrawable(this, R.drawable.eng)
            LANGUAGE_ARABIC -> return ContextCompat.getDrawable(this, R.drawable.arabic)
            else -> {
                Log.w(TAG, "Unsupported language")
                return null
            }
        }
    }

    companion object {

        private val TAG = "BaseActivity"
    }
}
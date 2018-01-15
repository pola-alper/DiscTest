package com.example.keronpola.DiscTest.Util

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.example.kerojesus.DiscTest.R
import java.util.*

/**
* Created by pola on 2/22/2016.
*/


/**
 * RateThisApp<br></br>
 * A library to show the app rate dialog
 * @author Keisuke Kobayashi (k.kobayashi.122@gmail.com)
 */
object RateThisApp {

    /**
     * If true, print LogCat
     */
    val DEBUG = false
    private val TAG = RateThisApp::class.java.simpleName
    private val PREF_NAME = "RateThisApp"
    private val KEY_INSTALL_DATE = "rta_install_date"
    private val KEY_LAUNCH_TIMES = "rta_launch_times"
    private val KEY_OPT_OUT = "rta_opt_out"
    private var mInstallDate = Date()
    private var mLaunchTimes = 1
    private var mOptOut = false
    private var sConfig = Config()

    @SuppressLint("ApplySharedPref")
            /**
     * Call this API when the launcher activity is launched.<br></br>
     * It is better to call this API in onStart() of the launcher activity.
     * @param context Context
     */
    fun onStart(context: Context) {
        val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        // If it is the first launch, save the date in shared preference.
        if (pref.getLong(KEY_INSTALL_DATE, 0) == 0L) {
            val now = Date()
            editor.putLong(KEY_INSTALL_DATE, now.time)
            log("First install: " + now.toString())
        }
        // Increment launch times
        var launchTimes = pref.getInt(KEY_LAUNCH_TIMES, 0)
        launchTimes++
        editor.putInt(KEY_LAUNCH_TIMES, launchTimes)
        log("Launch times; " + launchTimes)

        editor.commit()

        mInstallDate = Date(pref.getLong(KEY_INSTALL_DATE, 0))
        mLaunchTimes = pref.getInt(KEY_LAUNCH_TIMES, 0)
        mOptOut = pref.getBoolean(KEY_OPT_OUT, false)

        printStatus(context)
    }

    /**
     * Show the rate dialog if the criteria is satisfied.
     * @param context Context
     * @return true if shown, false otherwise.
     */
    fun showRateDialogIfNeeded(context: Context): Boolean {
        return if (shouldShowRateDialog()) {
            showRateDialog(context)
            true
        } else {
            false
        }
    }

    /**
     * Check whether the rate dialog should be shown or not
     * @return
     */
    private fun shouldShowRateDialog(): Boolean {
        if (mOptOut) {
            return false
        } else {
            if (mLaunchTimes >= sConfig.mCriteriaLaunchTimes) {
                return true
            }
            val threshold = sConfig.mCriteriaInstallDays.toLong() * 24 * 60 * 60 * 1000L    // msec
            return Date().time - mInstallDate.time >= threshold
        }
    }

    /**
     * Show the rate dialog
     * @param context
     */
    fun showRateDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        val titleId = if (sConfig.mTitleId != 0) sConfig.mTitleId else R.string.rta_dialog_title
        val messageId = if (sConfig.mMessageId != 0) sConfig.mMessageId else R.string.rta_dialog_message
        builder.setTitle(titleId)
        builder.setMessage(messageId)
        builder.setPositiveButton(R.string.rta_dialog_ok) { _, _ ->
            val appPackage = context.packageName
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackage))
            context.startActivity(intent)
            setOptOut(context, true)
        }
        builder.setNeutralButton(R.string.rta_dialog_cancel) { _, _ -> clearSharedPreferences(context) }
        builder.setNegativeButton(R.string.rta_dialog_no) { _, _ -> setOptOut(context, true) }
        builder.setOnCancelListener { clearSharedPreferences(context) }
        builder.create().show()
    }

    /**
     * Clear data in shared preferences.<br></br>
     * This API is called when the rate dialog is approved or canceled.
     * @param context
     */
    @SuppressLint("ApplySharedPref")
    private fun clearSharedPreferences(context: Context) {
        val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.remove(KEY_INSTALL_DATE)
        editor.remove(KEY_LAUNCH_TIMES)
        editor.commit()
    }

    /**
     * Set opt out flag. If it is true, the rate dialog will never shown unless app data is cleared.
     * @param context
     * @param optOut
     */
    @SuppressLint("ApplySharedPref")
    private fun setOptOut(context: Context, optOut: Boolean) {
        val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putBoolean(KEY_OPT_OUT, optOut)
        editor.commit()
    }

    /**
     * Print values in SharedPreferences (used for debug)
     * @param context
     */
    private fun printStatus(context: Context) {
        val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        log("*** RateThisApp Status ***")
        log("Install Date: " + Date(pref.getLong(KEY_INSTALL_DATE, 0)))
        log("Launch Times: " + pref.getInt(KEY_LAUNCH_TIMES, 0))
        log("Opt out: " + pref.getBoolean(KEY_OPT_OUT, false))
    }

    /**
     * Print log if enabled
     * @param message
     */
    private fun log(message: String) {
        if (DEBUG) {
            Log.v(TAG, message)
        }
    }

    /**
     * RateThisApp configuration.
     */
    class Config
    /**
     * Constructor.
     * @param criteriaInstallDays
     * @param criteriaLaunchTimes
     */
    @JvmOverloads constructor(val mCriteriaInstallDays: Int = 7, val mCriteriaLaunchTimes: Int = 10) {
        var mTitleId = 0
        var mMessageId = 0

    }
    /**
     * Constructor with default criteria.
     */
}

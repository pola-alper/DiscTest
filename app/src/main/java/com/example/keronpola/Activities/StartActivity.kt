package com.example.keronpola.DiscTest.Activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.BaseActivityK
import com.example.keronpola.DiscTest.Util.RateThisApp
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivityK(), View.OnClickListener {
    private var dialog: AlertDialog.Builder? = null
    private lateinit var PACKAGE_NAME: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        RateThisApp.showRateDialogIfNeeded(this)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        PACKAGE_NAME = applicationContext.packageName
        btnstart.setOnClickListener(this)

        imageButton.setOnClickListener {
            //Creating the instance of PopupMenu
            val popup = PopupMenu(this, imageButton)
            //Inflating the Popup using xml file
            popup.menuInflater.inflate(R.menu.dots_menu, popup.menu)

            //registering popup with OnMenuItemClickListener
            popup.setOnMenuItemClickListener({ item ->
                when (item.itemId) {
                    R.id.per -> {
                        val kk = Intent(this, PersonalitiesK::class.java)
                        startActivity(kk)
                    }
                    R.id.lan -> {
                        val ss = Intent(this, LanChangeK::class.java)
                        startActivity(ss)
                    }
                    R.id.rate -> {
                        val rateapp= RateThisApp
                        rateapp.showRateDialog(this)
                    }
                    R.id.about -> {
                        val ii = Intent(this, AboutActivityK::class.java)
                        startActivity(ii)
                    }
                    R.id.contact -> {
                        val cc: Intent = Intent(this, ContactUsK::class.java)
                        startActivity(cc)
                    }
                    R.id.share -> {
                        val sendIntent = Intent()
                        sendIntent.action = Intent.ACTION_SEND
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=$packageName")
                        sendIntent.type = "text/plain"
                        startActivity(sendIntent)
                    }
                }

                false
            })

            popup.show()
        }
    }


    override fun onBackPressed() {


        dialog = AlertDialog.Builder(this)


        //set Title
        dialog!!.setTitle(resources.getString(R.string.dialog_title))

        //set message
        dialog!!.setMessage(resources.getString(R.string.dialog_message))

        //set cancelable
        dialog!!.setCancelable(false)

        // set an icon
        dialog!!.setIcon(R.drawable.disclogove)

        //se Positive button
        dialog!!.setPositiveButton(resources.getString(R.string.positive_button)

        ) { _, _ ->
            //Exit our activity
            finish()
        }


        // set negative button
        dialog!!.setNegativeButton(resources.getString(R.string.negative_button)
        ) { dialog, _ -> dialog.cancel() }


        // create dialog
        val alertD = dialog!!.create()


        //show dialog
        alertD.show()
    }


    override fun onClick(v: View) {

        val p1 = Intent(this, Questions::class.java)
        startActivity(p1)
    }


}




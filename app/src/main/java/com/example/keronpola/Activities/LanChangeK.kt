package com.example.keronpola.DiscTest.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.LocaleManagerk
import kotlinx.android.synthetic.main.activity_lan.*


class LanChangeK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lan)
        english.setOnClickListener {
            setNewLocale(LocaleManagerk.LANGUAGE_ENGLISH,false)

        }
        arabic.setOnClickListener {
        setNewLocale(LocaleManagerk.LANGUAGE_ARABIC,false)
        }
    }

    private fun setNewLocale(language: String, restartProcess: Boolean): Boolean {
        LocaleManagerk.setNewLocale(this, language)

        val i = Intent(this, StartActivity::class.java)
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))


        return true
    }


}

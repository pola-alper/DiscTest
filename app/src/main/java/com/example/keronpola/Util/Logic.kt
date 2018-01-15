package com.example.keronpola.DiscTest.Util

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.keronpola.DiscTest.Activities.*
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment


public class Logic {

    fun send(d: Int, i: Int, s: Int, c: Int, q1: Questions) {

        if (d > i && d > s && d > c) {

            val window = Intent(q1, ResultActivity_DK::class.java)
            q1.startActivity(window)
            q1.finish()
        }
        if (i > d && i > s && i > c) {
            val window = Intent(q1, ResultActivity_IK::class.java)
            q1.startActivity(window)
            q1.finish()

        }
        if (s > i && s > d && s > c) {
            val window = Intent(q1, ResultActivity_SK::class.java)
            q1.startActivity(window)
            q1.finish()

        }
        if (c > i && c > s && c > d) {
            val window = Intent(q1, ResultActivity_CK::class.java)
            q1.startActivity(window)
            q1.finish()


        }


    }

    @SuppressLint("SetTextI18n")
    public fun iterate(textView: TextView, array: Array<String>) {
        for (l in array.indices) {

            textView.text = textView.text.toString() + "* " + array[l] + "\n\n"
        }
    }

    fun Youtube(youTubePlayerFragment: YouTubePlayerSupportFragment, API_KEY: String, URL: String, activity: FragmentActivity?) {
        youTubePlayerFragment.initialize(API_KEY, object : YouTubePlayer.OnInitializedListener {


            override fun onInitializationSuccess(provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean) {
                if (!wasRestored) {
                    player.setFullscreen(true)
                    player.loadVideo(URL)
                    //resources.getText(R.string.dvideoresult) as String)
                    player.play()
                }
            }


            override fun onInitializationFailure(provider: YouTubePlayer.Provider, error: YouTubeInitializationResult) {
                // YouTube error
                val errorMessage = error.toString()
                Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show()
                Log.d("errorMessage:", errorMessage)
            }
        })
    }
}






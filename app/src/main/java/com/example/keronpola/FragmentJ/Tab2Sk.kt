package com.example.keronpola.DiscTest.FragmentJ

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.Logic
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.tab2s.view.*

/**
 * Created by pola on 15-Jan-18.
 */


class Tab2Sk : Fragment() {
    private val API_KEY = "AIzaSyCPlbf4jeJnCK5bpOcVUlP1ylOcJ8TZtRY"
    private lateinit var url: String
    private lateinit var logic: Logic

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.tab2s, container, false)
 url = resources.getText(R.string.svideoresult) as String
        val youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance()
        logic = Logic()


        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.youtube_layout3, youTubePlayerFragment).commit()


        rootView.plays.setOnClickListener {
            logic.Youtube(youTubePlayerFragment, API_KEY, url, activity)

        }
        return rootView
    }


}
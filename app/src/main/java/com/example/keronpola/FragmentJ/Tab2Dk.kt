package com.example.keronpola.DiscTest.FragmentJ

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.Logic
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.tab2d.view.*


class Tab2Dk : Fragment() {
    private val API_KEY = "AIzaSyCPlbf4jeJnCK5bpOcVUlP1ylOcJ8TZtRY"
    private lateinit var url: String
    private lateinit var logic: Logic

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.tab2d, container, false)

        logic = Logic()
        val youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance()
        url = resources.getText(R.string.dvideoresult) as String

        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit()

        rootView.playd.setOnClickListener {
            logic.Youtube(youTubePlayerFragment, API_KEY, url, activity)


        }
        return rootView
    }


}
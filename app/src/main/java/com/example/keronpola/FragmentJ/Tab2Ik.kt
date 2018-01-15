package com.example.keronpola.DiscTest.FragmentJ

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.Logic
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.tab2i.view.*

/**
* Created by pola on 2/2/2016.
*/
class Tab2Ik : Fragment() {
    private val API_KEY = "AIzaSyCPlbf4jeJnCK5bpOcVUlP1ylOcJ8TZtRY"
    private lateinit var url:String
    private lateinit var logic : Logic

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.tab2i, container, false)
        logic = Logic()
 url = resources.getText(R.string.ivideoresult) as String
        val youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance()


        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.youtube_layout3, youTubePlayerFragment).commit()


        rootView.playi.setOnClickListener {
            logic.Youtube(youTubePlayerFragment, API_KEY, url, activity)
        }
        return rootView
    }


}
package com.example.keronpola.DiscTest.Adapter

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.FragmentJ.Tab1Sk
import com.example.keronpola.DiscTest.FragmentJ.Tab2Sk
import java.util.*

/**
* Created by pola on 3/16/2016.
*/
class PageAdapterS(fm: FragmentManager, internal var activity: Activity) : FragmentPagerAdapter(fm) {
    override fun getItem(i: Int): Fragment? {

        when (i) {
            0 -> {
                return Tab1Sk()
            }
            1 -> {
                return Tab2Sk()
            }
        }
        return null
    }


    override fun getCount(): Int {
        return 2
    }//set the number of tabs

    override fun getPageTitle(position: Int): CharSequence? {
        val l = Locale.getDefault()
        when (position) {
            0 -> return activity.resources.getString(R.string.description)
            1 ->

                return activity.resources.getString(R.string.video)
        }
        return null
    }

}

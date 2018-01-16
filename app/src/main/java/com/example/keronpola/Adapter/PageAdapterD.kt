package com.example.keronpola.Adapter

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.FragmentJ.Tab1DK
import com.example.keronpola.DiscTest.FragmentJ.Tab2Dk
import java.util.*

/**
* Created by pola on 2/6/2016.
*/
class PageAdapterD(fm: FragmentManager, internal var activity: Activity) : FragmentPagerAdapter(fm) {


    override fun getItem(i: Int): Fragment? {

        when (i) {
            0 -> {
                return Tab1DK()
            }
            1 -> {
                return Tab2Dk()
            }
        }
        return null
    }


    override fun getCount(): Int {
        return 2
    }//set the number of tabs

    override fun getPageTitle(position: Int): CharSequence? {
        Locale.getDefault()
        when (position) {
            0 -> return activity.resources.getString(R.string.description)
            1 ->

                return activity.resources.getString(R.string.video)
        }
        return null
    }


}

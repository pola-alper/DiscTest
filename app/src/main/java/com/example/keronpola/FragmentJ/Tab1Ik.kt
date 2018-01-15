package com.example.keronpola.DiscTest.FragmentJ

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kerojesus.DiscTest.R
import com.example.keronpola.DiscTest.Util.Logic
import kotlinx.android.synthetic.main.tab1i.view.*




/**
* Created by pola on 2/2/2016.
*/
class Tab1Ik : Fragment() {
    private lateinit var logic: Logic


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View
        val lf = activity!!.layoutInflater
        view = lf.inflate(R.layout.tab1i, container, false)
        val ias = resources.getStringArray(R.array.ias)
        val iaw = resources.getStringArray(R.array.iaw)
        val iai = resources.getStringArray(R.array.iai)
        val ian = resources.getStringArray(R.array.ian)
        val iae = resources.getStringArray(R.array.iae)
        val iac = resources.getStringArray(R.array.iac)
        val iaph = resources.getStringArray(R.array.iaph)
        val iamh = resources.getStringArray(R.array.iamh)
        val iadh = resources.getStringArray(R.array.iadh)
        val iam = resources.getStringArray(R.array.iam)
        logic = Logic()

        logic.iterate(view.spi, ias)

        logic.iterate(view.wpi, iaw)

        logic.iterate(view.isi, iai)

        logic.iterate(view.nedi, ian)

        logic.iterate(view.aspi, iae)

        logic.iterate(view.htci, iac)

        logic.iterate(view.htpi, iaph)

        logic.iterate(view.htmi, iamh)

        logic.iterate(view.htdi, iadh)

        logic.iterate(view.boi, iam)

        val share = activity!!.findViewById<View>(R.id.fab) as FloatingActionButton
        share.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,

                    resources.getString(R.string.tAb1d1) + "\n" + view.spi.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + view.wpi.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + view.isi.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + view.nedi.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + view.aspi.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + view.htci.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + view.htpi.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + view.htmi.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + view.htdi.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + view.boi.text
                            + "\n" + "https://www.youtube.com/watch?v=" + resources.getText(R.string.ivideoresult))
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }


        return view

    }


}

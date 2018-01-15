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
import kotlinx.android.synthetic.main.tab1c.view.*

/**
* Created by pola on 2/2/2016.
*/
class Tab1CK : Fragment() {
    private lateinit var logic: Logic


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View
        val lf = activity!!.layoutInflater
        view = lf.inflate(R.layout.tab1c, container, false)
        val cas = resources.getStringArray(R.array.cas)
        val caw = resources.getStringArray(R.array.caw)
        val cai = resources.getStringArray(R.array.cai)
        val can = resources.getStringArray(R.array.can)
        val cae = resources.getStringArray(R.array.cae)
        val cac = resources.getStringArray(R.array.cac)
        val aph = resources.getStringArray(R.array.aph)
        val am = resources.getStringArray(R.array.am)
        val amh = resources.getStringArray(R.array.amh)
        val adh = resources.getStringArray(R.array.adh)

       logic = Logic()
        logic.iterate(view.spc, cas)

        logic.iterate(view.wpc, caw)

        logic.iterate(view.isc, cai)

        logic.iterate(view.nedc, can)

        logic.iterate(view.aspc, cae)

        logic.iterate(view.htcc, cac)

        logic.iterate(view.htpc, aph)

        logic.iterate(view.htmc, amh)

        logic.iterate(view.htdc, adh)

        logic.iterate(view.boc, am)


        val share = activity!!.findViewById<View>(R.id.fab) as FloatingActionButton
        share.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,

                    resources.getString(R.string.tAb1d1) + "\n" + view.spc.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + view.wpc.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + view.isc.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + view.nedc.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + view.aspc.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + view.htcc.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + view.htpc.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + view.htmc.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + view.htdc.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + view.boc.text
                            + "\n" + "https://www.youtube.com/watch?v=" + resources.getText(R.string.cvideoresult))
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }

        return view
    }

}

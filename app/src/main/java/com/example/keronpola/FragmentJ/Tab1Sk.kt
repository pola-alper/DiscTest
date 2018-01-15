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
import kotlinx.android.synthetic.main.tab1s.view.*


class Tab1Sk : Fragment() {

    private lateinit var logic: Logic

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View
        val lf = activity!!.layoutInflater
        view = lf.inflate(R.layout.tab1s, container, false)
        logic = Logic()

        val sas = resources.getStringArray(R.array.sas)

        val saw = resources.getStringArray(R.array.saw)

        val sai = resources.getStringArray(R.array.sai)

        val san = resources.getStringArray(R.array.san)

        val sae = resources.getStringArray(R.array.sae)

        val sac = resources.getStringArray(R.array.sac)

        val saph = resources.getStringArray(R.array.saph)

        val samh = resources.getStringArray(R.array.samh)

        val sadh = resources.getStringArray(R.array.sadh)

        val sam = resources.getStringArray(R.array.sam)

        logic.iterate(view.sps, sas)

        logic.iterate(view.wps, saw)

        logic.iterate(view.iss, sai)

        logic.iterate(view.neds, san)

        logic.iterate(view.asps, sae)

        logic.iterate(view.htcs, sac)

        logic.iterate(view.htps, saph)

        logic.iterate(view.htms, samh)

        logic.iterate(view.htds, sadh)

        logic.iterate(view.bos, sam)



        val share = activity!!.findViewById<View>(R.id.fab) as FloatingActionButton

        share.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,

                    resources.getString(R.string.tAb1d1) + "\n" + view.sps.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + view.wps.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + view.iss.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + view.neds.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + view.asps.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + view.htcs.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + view.htps.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + view.htms.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + view.htds.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + view.bos.text
                            + "\n" + "https://www.youtube.com/watch?v=" + resources.getText(R.string.svideoresult))

            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }



        return view
    }
}

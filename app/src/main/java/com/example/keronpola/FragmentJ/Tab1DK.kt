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
import kotlinx.android.synthetic.main.tab1d.view.*

/**
 * Created by pola on 12-Jan-18.
 */


/**
* Created by pola on 2/2/2016.
*/
class Tab1DK : Fragment() {
    private lateinit var logic: Logic


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View
        val lf = activity!!.layoutInflater
        view = lf.inflate(R.layout.tab1d, container, false)
        val das = resources.getStringArray(R.array.das)
        val daw = resources.getStringArray(R.array.daw)
        val dai = resources.getStringArray(R.array.dai)
        val dan = resources.getStringArray(R.array.dan)
        val dae = resources.getStringArray(R.array.dae)
        val dac = resources.getStringArray(R.array.dac)
        val daph = resources.getStringArray(R.array.daph)
        val dam = resources.getStringArray(R.array.dam)
        val damh = resources.getStringArray(R.array.damh)
        val dadh = resources.getStringArray(R.array.dadh)
logic = Logic()

        logic.iterate(view.spd, das)

        logic.iterate(view.wpd, daw)

        logic.iterate(view.isd, dai)

        logic.iterate(view.nedd, dan)

        logic.iterate(view.aspd, dae)

        logic.iterate(view.htcd, dac)

        logic.iterate(view.htpd, daph)

        logic.iterate(view.htmd, damh)

        logic.iterate(view.htdd, dadh)

        logic.iterate(view.bod, dam)


        val share = activity!!.findViewById<View>(R.id.fab) as FloatingActionButton
        share.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,

                    resources.getString(R.string.tAb1d1) + "\n" + view.spd.text + "\n"
                            + resources.getString(R.string.tAb1d10) + "\n" + view.wpd.text + "\n"
                            + resources.getString(R.string.tAb1d19) + "\n" + view.isd.text + "\n"
                            + resources.getString(R.string.tAb1d27) + "\n" + view.nedd.text + "\n"
                            + resources.getString(R.string.tAb1d31) + "\n" + view.aspd.text + "\n"
                            + resources.getString(R.string.tAb1d35) + "\n" + view.htcd.text + "\n"
                            + resources.getString(R.string.tAb1d40) + "\n" + view.htpd.text + "\n"
                            + resources.getString(R.string.tAb1d43) + "\n" + view.htmd.text + "\n"
                            + resources.getString(R.string.tAb1d46) + "\n" + view.htdd.text + "\n"
                            + resources.getString(R.string.tAb1d50) + "\n" + view.bod.text
                            + "\n" + "https://www.youtube.com/watch?v=" + resources.getText(R.string.dvideoresult))

            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }

        return view
    }

}

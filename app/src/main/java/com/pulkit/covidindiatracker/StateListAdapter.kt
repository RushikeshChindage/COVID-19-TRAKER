package com.pulkit.covidindiatracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_list.view.*

class StateListAdapter(val list: List<StatewiseItem>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        val item = list[position]

        view.confirmedTv.apply {
            text = `SpannableDelta.kt`(
                "${item.confirmed}\n â†‘ ${item.deltaconfirmed ?: "0"}",
                "#D32F2F",
                item.confirmed?.length ?: 0
            )
        }
        view.activeTv.text = `SpannableDelta.kt`(
            "${item.active}\n â†‘ ${item.deltaactive ?: "0"}",
            "#1976D2",
            item.confirmed?.length ?: 0
        )
        view.recoveredTv.text = `SpannableDelta.kt`(
            "${item.recovered}\n â†‘ ${item.deltarecovered ?: "0"}",
            "#388E3C",
            item.recovered?.length ?: 0
        )
        view.deceasedTv.text = `SpannableDelta.kt`(
            "${item.deaths}\n â†‘ ${item.deltadeaths ?: "0"}",
            "#FBC02D",
            item.deaths?.length ?: 0
        )
        view.stateTv.text = item.state
        return view
    }

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount(): Int = list.size

}
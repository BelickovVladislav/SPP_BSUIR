package com.bobrov.spp_bsuir.ui.adapters.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bobrov.spp_bsuir.R

class TrainingTimeViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val start = view.findViewById<TextView>(R.id.timeStart)!!
    val finish = view.findViewById<TextView>(R.id.timeEnd)!!
    val duration = view.findViewById<TextView>(R.id.timeDuration)!!
}
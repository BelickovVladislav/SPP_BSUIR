package com.bobrov.spp_bsuir.ui.adapters.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bobrov.spp_bsuir.R

class NewsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.newsTitle)!!
    val description = view.findViewById<TextView>(R.id.newsDescription)!!
    val timeCreate = view.findViewById<TextView>(R.id.newsTimeCreate)!!
}
package com.appyfurious.spp_bsuir.ui.adapters.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.appyfurious.spp_bsuir.R

class MainViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val categoryName = view.findViewById<TextView>(R.id.category_name)!!
}
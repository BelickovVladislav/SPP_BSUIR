package com.appyfurious.spp_bsuir.ui.adapters.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.appyfurious.spp_bsuir.R

class CourseViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.titleCourse)!!
    val certificate = CertificateViewHolder(view)
    val trainigTime = TrainingTimeViewHolder(view)
}
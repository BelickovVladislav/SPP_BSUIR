package com.appyfurious.spp_bsuir.ui.adapters.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.appyfurious.spp_bsuir.R

class TeacherViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.nameTeacher)!!
    val email = view.findViewById<TextView>(R.id.emailTeacher)!!
    val position = view.findViewById<TextView>(R.id.positionTeacher)!!
}
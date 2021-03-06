package com.bobrov.spp_bsuir.ui.adapters.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bobrov.spp_bsuir.R

class CertificateViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.certificateTitle)!!
    val description = view.findViewById<TextView>(R.id.certificateDescription)!!
    val date = view.findViewById<TextView>(R.id.certificateDate)!!
}
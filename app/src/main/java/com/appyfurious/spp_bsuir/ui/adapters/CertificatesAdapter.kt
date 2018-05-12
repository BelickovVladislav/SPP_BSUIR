package com.appyfurious.spp_bsuir.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appyfurious.spp_bsuir.entity.Certificate
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.ui.adapters.view_holder.CertificatesViewHolder
import java.text.SimpleDateFormat

class CertificatesAdapter(private val context: Context,
                          private val certificates: List<Certificate>)
    : RecyclerView.Adapter<CertificatesViewHolder>() {

    override fun getItemCount() = certificates.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificatesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_certificate, parent, false)
        return CertificatesViewHolder(view)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: CertificatesViewHolder, position: Int) {
        val certificate = certificates[position]
        holder.title.text = certificate.name
        holder.description.text = certificate.decription
        val formatter = SimpleDateFormat("dd.MM.yy HH:mm")
        holder.date.text = formatter.format(certificate.dateReceipt)
    }
}
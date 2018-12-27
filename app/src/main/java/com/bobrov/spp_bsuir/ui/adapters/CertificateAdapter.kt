package com.bobrov.spp_bsuir.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bobrov.spp_bsuir.entity.Certificate
import com.bobrov.spp_bsuir.R
import com.bobrov.spp_bsuir.format.DateFormat
import com.bobrov.spp_bsuir.ui.adapters.holder.CertificateViewHolder

class CertificateAdapter(private val context: Context,
                         private val certificates: List<Certificate>)
    : RecyclerView.Adapter<CertificateViewHolder>() {

    override fun getItemCount() = certificates.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificateViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_certificate, parent, false)
        return CertificateViewHolder(view)
    }

    override fun onBindViewHolder(holder: CertificateViewHolder, position: Int) {
        val certificate = certificates[position]
        holder.title.text = certificate.name
        holder.description.text = certificate.description
        holder.date.text = DateFormat().format(certificate.dateReceipt)
    }
}
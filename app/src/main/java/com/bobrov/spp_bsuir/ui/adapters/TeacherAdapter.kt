package com.bobrov.spp_bsuir.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bobrov.spp_bsuir.R
import com.bobrov.spp_bsuir.entity.Teacher
import com.bobrov.spp_bsuir.ui.adapters.holder.TeacherViewHolder

class TeacherAdapter(private val context: Context,
                     private val items: List<Teacher>) : RecyclerView.Adapter<TeacherViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val item = items[position]
        holder.apply {
            email.text = item.email
            name.text = item.name
            this.position.text = item.position
        }
    }
}
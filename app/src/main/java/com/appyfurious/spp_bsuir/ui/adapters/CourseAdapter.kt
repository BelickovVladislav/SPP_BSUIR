package com.appyfurious.spp_bsuir.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.entity.Course
import com.appyfurious.spp_bsuir.format.DateFormat
import com.appyfurious.spp_bsuir.ui.adapters.holder.CourseViewHolder
import java.util.*

class CourseAdapter(private val context: Context,
                    private val list: List<Course>) : RecyclerView.Adapter<CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val item = list[position]
        val formatter = DateFormat()
        val start = item.trainigTime?.start
        val finish = item.trainigTime?.finish
        val duration = Date((finish?.time ?: 0) - (start?.time ?: 0))
        holder.title.text = item.name
        holder.certificate.date.text = formatter.format(item.certificate?.dateReceipt)
        holder.certificate.description.text = item.certificate?.description
        holder.certificate.title.text = item.certificate?.name
        holder.trainigTime.start.text = formatter.format(start)
        holder.trainigTime.finish.text = formatter.format(finish)
        holder.trainigTime.duration.text = formatter.format(duration)
    }
}
package com.appyfurious.spp_bsuir.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.ui.adapters.holder.MainViewHolder

class MainAdapter(private val context: Context,
                  private val items: List<String>,
                  private val listener: MainItemListener): RecyclerView.Adapter<MainViewHolder>() {

    interface MainItemListener {
        fun onClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.view.setOnClickListener { listener.onClick(it, position) }
        holder.categoryName.text = items[position]
    }
}
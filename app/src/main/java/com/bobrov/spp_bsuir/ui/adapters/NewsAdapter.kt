package com.bobrov.spp_bsuir.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bobrov.spp_bsuir.entity.News
import com.bobrov.spp_bsuir.R
import com.bobrov.spp_bsuir.format.DateFormat
import com.bobrov.spp_bsuir.ui.adapters.holder.NewsViewHolder

class NewsAdapter(private val context: Context, private val newsList: List<News>): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount() = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.title.text = news.title
        holder.description.text = news.description
        holder.timeCreate.text = DateFormat().format(news.creationDate)
    }
}
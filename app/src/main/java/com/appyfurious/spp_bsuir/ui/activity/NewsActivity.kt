package com.appyfurious.spp_bsuir.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.appyfurious.spp_bsuir.Entity.News
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.ui.adapters.NewsAdapter
import java.util.*

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsList.layoutManager = LinearLayoutManager(this)
        //TODO read DB
        newsList.adapter = NewsAdapter(this, listOf(
                getNews("title 1", "description 1", Calendar.getInstance().time),
                getNews("title 2", "description 1", Calendar.getInstance().time),
                getNews("title 3", "description 1", Calendar.getInstance().time),
                getNews("title 4", "description 1", Calendar.getInstance().time)
        ))
    }

    private fun getNews(title: String, description: String, timeCreate: Date): News {
        val news = News()
        news.title = title
        news.description = description
        news.creationDate = timeCreate
        return news
    }
}

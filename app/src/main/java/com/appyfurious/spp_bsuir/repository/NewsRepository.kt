package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.Entity.News
import java.util.*

class NewsRepository {
    fun add(news: News) {
        news.id = UUID.randomUUID().toString()
        //TODO news.scopeId
    }

    fun get() {
        
    }
}
package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.entity.News
import io.realm.Realm
import java.util.*

class NewsRepository {
    fun add(news: News) {
        news.id = UUID.randomUUID().toString()
        Realm.getDefaultInstance().executeTransaction {
            it.insert(news)
        }
    }

    fun getAll(body: (_: List<News>) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            body(it.where(News::class.java).findAll())
        }
    }
}
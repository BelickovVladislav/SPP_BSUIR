package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.entity.News
import com.appyfurious.spp_bsuir.entity.Scope
import io.realm.Realm
import java.util.*

class NewsRepository {

    private val news = listOf(
            News.create("idnews1", "новость 1", "всех отчислят", Scope.ALL_KEY),
            News.create("idnews2", "новость 2", "всех отчислят 2", Scope.ALL_KEY),
            News.create("idnews3", "новость 3", "всех отчислят 3", Scope.ALL_KEY)
    )

    fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.insertOrUpdate(news)
        }
    }

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

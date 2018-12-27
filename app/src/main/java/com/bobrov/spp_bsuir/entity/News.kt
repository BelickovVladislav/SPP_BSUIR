package com.bobrov.spp_bsuir.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class News: RealmObject() {

    companion object {
        fun create(id: String, title: String, description: String, scopeId: String) = News().apply {
            this.id = id
            this.title = title
            this.description = description
            this.scopeId = scopeId
        }
    }

    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var title: String? = null
    var description: String? = null
    var creationDate = Calendar.getInstance().time!!
    var scopeId: String? = null
}
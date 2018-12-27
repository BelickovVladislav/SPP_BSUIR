package com.bobrov.spp_bsuir.entity

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Teacher: RealmObject() {

    companion object {
        fun create(id: String, name: String, email: String, password: String, position: String) = Teacher().apply {
            this.id = id
            this.name = name
            this.email = email
            this.password = password
            this.position = position
        }
    }

    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var email: String? = null
    var password: String? = null
    var name: String? = null
    var position: String? = null
    var courses = RealmList<Course>()
    var news = RealmList<News>()
    var comments = RealmList<Comment>()
}
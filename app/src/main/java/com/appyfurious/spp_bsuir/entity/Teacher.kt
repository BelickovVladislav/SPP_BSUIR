package com.appyfurious.spp_bsuir.entity

import io.realm.RealmList
import io.realm.RealmObject
import java.util.*

open class Teacher: RealmObject() {
    var id = UUID.randomUUID().toString()
    var email: String? = null
    var password: String? = null
    var name: String? = null
    var position: String? = null
    var courses = RealmList<Course>()
    var news = RealmList<News>()
    var comments = RealmList<Comment>()
}
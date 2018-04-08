package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmList
import io.realm.RealmObject

class Teacher: RealmObject() {
    var name: String? = null
    var position: String? = null
    var courses = RealmList<Course>()
    var news = RealmList<News>()
    var comments = RealmList<Comment>()
}
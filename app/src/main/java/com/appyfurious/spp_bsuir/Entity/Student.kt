package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmList
import io.realm.RealmObject
import java.util.*

open class Student: RealmObject() {
    var id = UUID.randomUUID().toString()
    var email: String? = null
    var password: String? = null
    var name: String? = null
    var courseId: String? = null
    var certificates = RealmList<Certificate>()
    var comments = RealmList<Comment>()
}
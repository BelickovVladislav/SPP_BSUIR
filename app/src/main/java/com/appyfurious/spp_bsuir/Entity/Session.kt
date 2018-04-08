package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Session: RealmObject() {
    @PrimaryKey
    var userId: String? = null
    var isTeacher = false
    var isAuth = false
}
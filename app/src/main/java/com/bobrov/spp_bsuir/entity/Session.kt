package com.bobrov.spp_bsuir.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Session: RealmObject() {
    @PrimaryKey
    var email: String? = null
    var isTeacher = false
    var isAuth = false
}
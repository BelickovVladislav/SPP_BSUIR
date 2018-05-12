package com.appyfurious.spp_bsuir.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Scope: RealmObject() {
    companion object {
        const val ALL_KEY = "0"
        const val STUDENT_KEY = "1"
        const val TEACHER_KEY = "2"
    }
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var name: String? = null
}
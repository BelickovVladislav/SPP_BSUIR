package com.appyfurious.spp_bsuir.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Comment: RealmObject() {
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var title: String? = null
    var description: String? = null
    var dateCreate = Calendar.getInstance().time!!
}
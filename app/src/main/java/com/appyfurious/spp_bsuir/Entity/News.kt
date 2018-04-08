package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class News: RealmObject() {
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var title: String? = null
    var description: String? = null
    var creationDate = Calendar.getInstance().time!!
    var scopeId: String? = null
}
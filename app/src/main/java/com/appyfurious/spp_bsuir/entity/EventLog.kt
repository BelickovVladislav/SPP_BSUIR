package com.appyfurious.spp_bsuir.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class EventLog: RealmObject() {
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var date = Calendar.getInstance().time!!
    var description: String? = null
}
package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Certificate: RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var name: String? = null
    var decription: String? = null
    var dateReceipt: Date? = null
}
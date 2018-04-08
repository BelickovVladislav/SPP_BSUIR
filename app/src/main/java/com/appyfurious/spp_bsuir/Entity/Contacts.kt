package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Contacts: RealmObject() {
    @PrimaryKey
    var id: String =  UUID.randomUUID().toString()
    var title: String? = null
    var description: String? = null
    var email: String? = null
    var address: String? = null
}
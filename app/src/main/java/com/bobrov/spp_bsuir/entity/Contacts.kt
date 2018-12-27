package com.bobrov.spp_bsuir.entity

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
package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class TrainingType: RealmObject() {
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var name: String? = null
}
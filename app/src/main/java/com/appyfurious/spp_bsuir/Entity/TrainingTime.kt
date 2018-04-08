package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import java.util.*

open class TrainingTime: RealmObject() {
    var id = UUID.randomUUID().toString()
    var start: Date? = null
    var finish: Date? = null
    var duration: Date? = null
}
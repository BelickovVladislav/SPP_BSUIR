package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import java.util.*

open class Module: RealmObject() {
    var id = UUID.randomUUID().toString()
    var name: String? = null
    var trainingTime: TrainingTime? = null
}
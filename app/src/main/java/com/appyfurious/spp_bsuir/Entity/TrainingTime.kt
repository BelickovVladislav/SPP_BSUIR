package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject
import java.util.*

class TrainingTime: RealmObject() {
    var start: Date? = null
    var finish: Date? = null
    var duration: Date? = null
}
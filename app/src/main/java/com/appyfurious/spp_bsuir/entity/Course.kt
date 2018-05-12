package com.appyfurious.spp_bsuir.entity

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Course: RealmObject() {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var name: String? = null
    var certificate = RealmList<Certificate>()
    var commetns = RealmList<Comment>()
    var trainigTime: TrainingTime? = null
    var modules = RealmList<Module>()
    var trainingType: TrainingType? = null
}
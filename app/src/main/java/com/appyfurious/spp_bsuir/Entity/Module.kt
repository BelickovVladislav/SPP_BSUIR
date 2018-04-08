package com.appyfurious.spp_bsuir.Entity

import io.realm.RealmObject

class Module: RealmObject() {
    var name: String? = null
    var trainingTime: TrainingTime? = null
}
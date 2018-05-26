package com.appyfurious.spp_bsuir.entity

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Course : RealmObject() {

    companion object {
        fun create(id: String, certificateId: String, trainingTime: TrainingTime,
                   certificates: List<Certificate>?) = Course().apply {
            val certificate = certificates?.firstOrNull { it.id == certificateId }
            this.id = id
            this.name = certificate?.name
            this.certificate = certificate
            this.trainigTime = trainingTime
        }
    }

    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var name: String? = null
    var certificate: Certificate? = null
    var commetns = RealmList<Comment>()
    var trainigTime: TrainingTime? = null
    var modules = RealmList<Module>()
}
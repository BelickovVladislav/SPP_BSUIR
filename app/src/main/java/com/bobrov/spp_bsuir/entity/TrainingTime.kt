package com.bobrov.spp_bsuir.entity

import io.realm.RealmObject
import java.util.*

open class TrainingTime: RealmObject() {

    companion object {
        fun create(start: Date, finish: Date) = TrainingTime().apply {
            this.start = start
            this.finish = finish
        }
    }

    var id = UUID.randomUUID().toString()
    var start: Date? = null
    var finish: Date? = null
    fun duration() = ((finish?.time ?: 0) - (start?.time ?: 0)) / 1000 / 60
}
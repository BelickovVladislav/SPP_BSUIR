package com.appyfurious.spp_bsuir.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Certificate : RealmObject() {

    companion object {
        const val BASIC_TYPE = "Базовый"
        const val ADVANCED_TYPE = "Продвинутый"
        const val TOP_TYPE = "Углубленный"

        fun create(id: String, type: String, name: String, description: String) = Certificate().apply {
            this.id = id
            this.type = type
            this.name = name
            this.description = description
            this.dateReceipt = Calendar.getInstance().time
        }
    }

    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var type: String? = null
    var name: String? = null
    var description: String? = null
    var dateReceipt: Date? = null
}
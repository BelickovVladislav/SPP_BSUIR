package com.appyfurious.spp_bsuir.Entity

import io.realm.annotations.PrimaryKey
import java.util.*

class Certificate {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var name: String? = null
    var decription: String? = null
    var dateReceipt: Date? = null
}
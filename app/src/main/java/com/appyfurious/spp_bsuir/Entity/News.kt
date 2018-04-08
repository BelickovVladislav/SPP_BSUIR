package com.appyfurious.spp_bsuir.Entity

import io.realm.annotations.PrimaryKey
import java.util.*

class News {
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var title: String? = null
    var description: String? = null
    var creationDate = Calendar.getInstance().time!!
    var scopeId: String? = null
}
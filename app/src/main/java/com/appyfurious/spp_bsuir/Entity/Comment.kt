package com.appyfurious.spp_bsuir.Entity

import io.realm.annotations.PrimaryKey
import java.util.*

class Comment {
    @PrimaryKey
    var id = UUID.randomUUID().toString()
    var title: String? = null
    var description: String? = null
    var dateCreate = Calendar.getInstance().time!!
}
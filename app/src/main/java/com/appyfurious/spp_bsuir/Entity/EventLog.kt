package com.appyfurious.spp_bsuir.Entity

import io.realm.annotations.PrimaryKey
import java.util.*

class EventLog {
    @PrimaryKey
    var date = Calendar.getInstance().time!!
    var description: String? = null
}
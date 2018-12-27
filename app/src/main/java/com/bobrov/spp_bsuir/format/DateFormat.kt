package com.bobrov.spp_bsuir.format

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DateFormat {

    @SuppressLint("SimpleDateFormat")
    fun format(date: Date?): String {
        val formatter = SimpleDateFormat("dd.MM.yy HH:mm")
        return if (date == null) "" else {
            formatter.format(date)
        }
    }
}
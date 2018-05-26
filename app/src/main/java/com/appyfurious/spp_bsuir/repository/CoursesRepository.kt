package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.entity.Certificate
import com.appyfurious.spp_bsuir.entity.Course
import com.appyfurious.spp_bsuir.entity.TrainingTime
import io.realm.Realm
import java.util.*

class CoursesRepository {

    private var certificates: List<Certificate>? = null
    private fun start() = Calendar.getInstance().time
    private fun finish(hours: Int): Date {
        val date = Calendar.getInstance()
        date.add(Calendar.HOUR, hours)
        return date.time
    }

    private val courses = listOf(
            Course.create("001", CertificatesRepository.BASIC_ID, TrainingTime.create(start(), finish(20)), certificates),
            Course.create("002", CertificatesRepository.ADVANCED_ID, TrainingTime.create(start(), finish(30)), certificates),
            Course.create("003", CertificatesRepository.TOP_ID, TrainingTime.create(start(), finish(40)), certificates)
    )

    init {
        CertificatesRepository().get { certificates = it }
    }

    private fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.insertOrUpdate(courses)
        }
    }
}

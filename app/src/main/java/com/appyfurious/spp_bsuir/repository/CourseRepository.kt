package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.entity.Certificate
import com.appyfurious.spp_bsuir.entity.Course
import com.appyfurious.spp_bsuir.entity.TrainingTime
import io.realm.Realm
import java.util.*

class CourseRepository {

    private var certificates: List<Certificate>? = null
    private fun start() = Calendar.getInstance().time
    private fun finish(hours: Int): Date {
        val date = Calendar.getInstance()
        date.add(Calendar.HOUR, hours)
        return date.time
    }

    private var courses: List<Course>? = null

    init {
        CertificateRepository().get {
            certificates = it
            courses = listOf(
                    Course.create("001", CertificateRepository.BASIC_ID,
                            TrainingTime.create(start(), finish(20)), certificates),

                    Course.create("002", CertificateRepository.ADVANCED_ID,
                            TrainingTime.create(start(), finish(30)), certificates),

                    Course.create("003", CertificateRepository.TOP_ID,
                            TrainingTime.create(start(), finish(40)), certificates)
            )
        }
    }

    fun get(body: (List<Course>) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            body(it.where(Course::class.java).findAll())
        }
    }

    fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.insertOrUpdate(courses)
        }
    }
}

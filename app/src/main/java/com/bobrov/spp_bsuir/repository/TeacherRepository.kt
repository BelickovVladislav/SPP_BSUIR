package com.bobrov.spp_bsuir.repository

import com.bobrov.spp_bsuir.entity.Teacher
import io.realm.Realm

class TeacherRepository {

    private val teacher = listOf(
            Teacher.create("teacher1", "Владислав Сергеевич", "belka@gmail.com", "1234", "php"),
            Teacher.create("teacher2", "Александр Сергеевич", "tih@gmail.com", "1234", "automatic test"),
            Teacher.create("teacher3", "Николай Николаевич", "bk97w@bk.ru", "1234", "android")
    )

    fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.insertOrUpdate(teacher)
        }
    }

    fun get(body: (List<Teacher>) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            body(it.where(Teacher::class.java).findAll())
        }
    }
}
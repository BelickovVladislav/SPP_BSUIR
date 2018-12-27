package com.bobrov.spp_bsuir.repository

import com.bobrov.spp_bsuir.entity.Session
import com.bobrov.spp_bsuir.entity.Student
import com.bobrov.spp_bsuir.entity.Teacher
import io.realm.Realm

class AuthRepository {

    val usersTypeList = arrayListOf(
            "Учащийся",
            "Преподаватель"
    )

    fun isValid(email: String, password: String, type: String?, body: (_: Boolean) -> Unit) {
        val userType = type ?: usersTypeList[0]
        Realm.getDefaultInstance().executeTransaction {
            //TODO реализовать проверку
            if (userType == usersTypeList[0]) {
                val student = it.where(Student::class.java).findAll()
                        .firstOrNull { it.email == email && it.password == password }
                body(student != null)
            }
            if (userType == usersTypeList[1]) {
                val teacher = it.where(Teacher::class.java).findAll()
                        .firstOrNull { it.email == email && it.password == password }
                body(teacher != null)
            }
        }
    }

    fun isAuth(body: (_: Boolean) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            val isAuth = it.where(Session::class.java).findAll().firstOrNull { it.isAuth } != null
            body(isAuth)
        }
    }

    fun authNewUser(fullName: String, email: String, password: String, type: String?, body: (_: Boolean) -> Unit) {
        val userType = type ?: usersTypeList[0]
        Realm.getDefaultInstance().executeTransaction {
            if (userType == usersTypeList[0]) {
                val user = it.createObject(Student::class.java)
                user.name = fullName
                user.email = email
                user.password = password
                body(authUser(email, it, false))
            } else {
                val teacher = it.createObject(Teacher::class.java)
                teacher.name = fullName
                teacher.email = email
                teacher.password = password
                body(authUser(email, it, true))
            }
        }
    }

    private fun authUser(email: String, realm: Realm, isTeacher: Boolean): Boolean {
        val sessions = realm.where(Session::class.java).findAll()
        var session = sessions.firstOrNull { it.email == email }
        val isRegister = session == null
        session = Session()
        if (isRegister) {
            sessions.map { it.isAuth = false }
            session.isAuth = true
            session.email = email
            session.isTeacher = isTeacher
            realm.insert(session)
        }
        return isRegister
    }
}
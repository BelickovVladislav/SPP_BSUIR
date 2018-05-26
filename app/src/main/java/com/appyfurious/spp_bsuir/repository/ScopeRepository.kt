package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.entity.Scope
import io.realm.Realm

class ScopeRepository {

    private val scopes = listOf(
            Scope.create(Scope.ALL_KEY, "Все"),
            Scope.create(Scope.STUDENT_KEY, "Студенты"),
            Scope.create(Scope.TEACHER_KEY, "Преподаватели")
    )

    fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.insertOrUpdate(scopes)
        }
    }

    fun getAll(body: (_: List<Scope>) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            body(it.where(Scope::class.java).findAll())
        }
    }
}
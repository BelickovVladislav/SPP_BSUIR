package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.Entity.Scope
import io.realm.Realm

class ScopeRepository {

    private val scopes = listOf(
            create(Scope.ALL_KEY, "Все"),
            create(Scope.STUDENT_KEY, "Студенты"),
            create(Scope.TEACHER_KEY, "Преподаватели")
    )

    fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.where(Scope::class.java).findAll().deleteAllFromRealm()
            it.insert(scopes)
        }
    }

    private fun create(id: String, name: String): Scope {
        val scope = Scope()
        scope.id = id
        scope.name = name
        return scope
    }

    fun getAll(body: (_: List<Scope>) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            body(it.where(Scope::class.java).findAll())
        }
    }
}
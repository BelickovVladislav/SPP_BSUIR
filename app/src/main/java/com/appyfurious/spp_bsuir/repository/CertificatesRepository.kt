package com.appyfurious.spp_bsuir.repository

import com.appyfurious.spp_bsuir.entity.Certificate
import io.realm.Realm
import io.realm.kotlin.where
import java.util.*

class CertificatesRepository {

    private val certificates = listOf(
            create("001", Certificate.BASIC_TYPE, "Английскйи: Начало", "Изучаем базовый английский с любого уровня."),
            create("002", Certificate.ADVANCED_TYPE, "Английский: Учимся говорить", "Изучаем разговорный английский с носителями языка."),
            create("003", Certificate.TOP_TYPE, "Почти англичанин", "Меняем гражданстов, и становимся гуру.")
    )

    fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.where(Certificate::class.java).findAll().deleteAllFromRealm()
            it.insert(certificates)
        }
    }

    fun get(body: (_:List<Certificate>) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            body(it.where(Certificate::class.java).findAll())
        }
    }

    private fun create(id: String, type: String, name: String, description: String) = Certificate().apply {
        this.id = id
        this.type = Certificate.BASIC_TYPE
        this.name = name
        this.decription = description
        this.dateReceipt = Calendar.getInstance().time
    }

}
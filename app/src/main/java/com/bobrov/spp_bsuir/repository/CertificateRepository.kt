package com.bobrov.spp_bsuir.repository

import com.bobrov.spp_bsuir.entity.Certificate
import io.realm.Realm
import java.util.*

class CertificateRepository {

    companion object {
        const val BASIC_ID = "001"
        const val ADVANCED_ID = "002"
        const val TOP_ID = "003"
    }

    private val certificates = listOf(
            Certificate.create(BASIC_ID, Certificate.BASIC_TYPE, "Английскйи: Начало", "Сертификат подтверждающий базовые знания по английскому языку."),
            Certificate.create(ADVANCED_ID, Certificate.ADVANCED_TYPE, "Английский: Учимся говорить", "Сертификат подтверждающий навык владения разговорным английским.."),
            Certificate.create(TOP_ID, Certificate.TOP_TYPE, "Почти англичанин", "Сертификат подтверждающий что английский вы знаете лучше чем мову.")
    )

    fun create(title: String, description: String, type: String) {
        Realm.getDefaultInstance().executeTransaction {
            it.insert(Certificate.create(UUID.randomUUID().toString(), type, title, description))
        }
    }

    fun create() {
        Realm.getDefaultInstance().executeTransaction {
            it.insertOrUpdate(certificates)
        }
    }

    fun get(body: (_:List<Certificate>) -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            body(it.where(Certificate::class.java).findAll())
        }
    }
}
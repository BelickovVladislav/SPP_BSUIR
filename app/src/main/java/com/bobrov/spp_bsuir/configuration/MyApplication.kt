package com.bobrov.spp_bsuir.configuration

import android.app.Application
import com.bobrov.spp_bsuir.repository.*
import io.realm.Realm

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        ScopeRepository().create()
        CertificateRepository().create()
        CourseRepository().create()
        NewsRepository().create()
        TeacherRepository().create()
        //belka
    }
}

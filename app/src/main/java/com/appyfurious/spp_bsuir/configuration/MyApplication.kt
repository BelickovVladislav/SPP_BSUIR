package com.appyfurious.spp_bsuir.configuration

import android.app.Application
import com.appyfurious.spp_bsuir.entity.News
import com.appyfurious.spp_bsuir.repository.CertificateRepository
import com.appyfurious.spp_bsuir.repository.CourseRepository
import com.appyfurious.spp_bsuir.repository.NewsRepository
import com.appyfurious.spp_bsuir.repository.ScopeRepository
import io.realm.Realm

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        ScopeRepository().create()
        CertificateRepository().create()
        CourseRepository().create()
        NewsRepository().create()
    }
}

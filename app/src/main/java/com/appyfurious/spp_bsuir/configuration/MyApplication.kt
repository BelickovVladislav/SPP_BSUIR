package com.appyfurious.spp_bsuir.configuration

import android.app.Application
import com.appyfurious.spp_bsuir.repository.CertificatesRepository
import com.appyfurious.spp_bsuir.repository.ScopeRepository
import io.realm.Realm

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        ScopeRepository().create()
        CertificatesRepository().create()
    }
}

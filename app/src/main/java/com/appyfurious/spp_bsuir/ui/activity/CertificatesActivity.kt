package com.appyfurious.spp_bsuir.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.repository.CertificatesRepository
import com.appyfurious.spp_bsuir.ui.adapters.CertificatesAdapter
import kotlinx.android.synthetic.main.activity_certificates.*

class CertificatesActivity : AppCompatActivity() {

    private val certificateRepository = CertificatesRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificates)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.certificates)

        listCertificates.layoutManager = LinearLayoutManager(this)

        certificateRepository.get {
            listCertificates.adapter = CertificatesAdapter(this, it)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

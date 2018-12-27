package com.bobrov.spp_bsuir.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.bobrov.spp_bsuir.R
import com.bobrov.spp_bsuir.repository.CertificateRepository
import com.bobrov.spp_bsuir.ui.adapters.CertificateAdapter
import kotlinx.android.synthetic.main.activity_certificates.*
//TODO не принтует все
class CertificatesActivity : AppCompatActivity() {

    private val certificateRepository = CertificateRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificates)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.certificates)

        listCertificates.layoutManager = LinearLayoutManager(this)

        certificateRepository.get {
            listCertificates.adapter = CertificateAdapter(this, it)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.item_create, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_object -> {
                startActivity(Intent(this, CreateCertificateActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

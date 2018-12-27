package com.bobrov.spp_bsuir.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bobrov.spp_bsuir.R
import com.bobrov.spp_bsuir.entity.Certificate
import com.bobrov.spp_bsuir.repository.CertificateRepository
import kotlinx.android.synthetic.main.activity_create_certificate.*

class CreateCertificateActivity : AppCompatActivity() {

    private val certificateRepository = CertificateRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_certificate)
        createCertificateType.adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                listOf(Certificate.BASIC_TYPE, Certificate.ADVANCED_TYPE, Certificate.TOP_TYPE))
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
                certificateRepository.create(
                        createCertificateTitle.text.toString(),
                        createCertificateDescription.text.toString(),
                        createCertificateType.selectedItem.toString())
                Toast.makeText(this, R.string.success_create_certificate, Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

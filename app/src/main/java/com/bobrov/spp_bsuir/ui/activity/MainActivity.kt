package com.bobrov.spp_bsuir.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bobrov.spp_bsuir.R
import com.bobrov.spp_bsuir.ui.adapters.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.MainItemListener {

    private val categoryItems = listOf(
            "Новости",
            "Курсы",
            "Преподаватели",
            "Сертификаты",
            "Ближайшие занятия",
            "Настройки",
            "Выход"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setTitle(R.string.learn_center)
        gridMainItems.layoutManager = LinearLayoutManager(this)
        gridMainItems.adapter = MainAdapter(this, categoryItems, this)
    }

    override fun onClick(view: View, position: Int) {
        val clazz = when (position) {
            0 -> NewsActivity::class.java
            1 -> CoursesActivity::class.java
            2 -> TeachersActivity::class.java
            3 -> CertificatesActivity::class.java
            4 -> null
            5 -> null
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this, it))
        }
        if (position == 6) {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        closeBuilder()
    }

    private fun closeBuilder() {
        AlertDialog.Builder(this).setTitle(R.string.exit)
                .setMessage(R.string.exit_message)
                .setNegativeButton(R.string.exit_true) { _, _ ->
                    super.onBackPressed()
                }.setPositiveButton(R.string.back) { _, _ -> }
                .create().show()
    }
}

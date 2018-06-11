package com.appyfurious.spp_bsuir.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.repository.TeacherRepository
import com.appyfurious.spp_bsuir.ui.adapters.TeacherAdapter
import kotlinx.android.synthetic.main.activity_teachers.*

class TeachersActivity : AppCompatActivity() {

    private val teacherRepository = TeacherRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teachers)
        supportActionBar?.setTitle(R.string.teacher_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        teachersList.layoutManager = LinearLayoutManager(this)
        teacherRepository.get {
            teachersList.adapter = TeacherAdapter(this, it)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

package com.appyfurious.spp_bsuir.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.repository.CourseRepository
import com.appyfurious.spp_bsuir.ui.adapters.CourseAdapter
import kotlinx.android.synthetic.main.activity_courses.*

class CoursesActivity : AppCompatActivity() {

    private val courseRepository = CourseRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        listCourses.layoutManager = LinearLayoutManager(this)
        courseRepository.get {
            listCourses.adapter = CourseAdapter(this, it)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

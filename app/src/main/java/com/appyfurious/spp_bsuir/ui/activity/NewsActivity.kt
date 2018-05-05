package com.appyfurious.spp_bsuir.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.appyfurious.spp_bsuir.Entity.News
import com.appyfurious.spp_bsuir.Entity.Scope
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.repository.NewsRepository
import com.appyfurious.spp_bsuir.repository.ScopeRepository
import com.appyfurious.spp_bsuir.ui.adapters.NewsAdapter
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val newsRepository = NewsRepository()
    private val scopeRepository = ScopeRepository()
    private lateinit var scopes: List<Scope>
    private lateinit var news: List<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsList.layoutManager = LinearLayoutManager(this)

        newsSpinner.onItemSelectedListener = this

        scopeRepository.getAll {
            scopes = it
            newsSpinner.adapter = ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, it.map { it.name })
        }
    }

    override fun onResume() {
        super.onResume()
        newsRepository.getAll {
            news = it
            newsList.adapter = NewsAdapter(this, it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.item_create, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_object -> {
                startActivity(Intent(this, NewsCreateActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        showNews(scopes[position].id)
    }

    private fun showNews(scopeId: String) {
        val news = news.filter { it.scopeId == scopeId }
        newsList.adapter = NewsAdapter(this, news)
    }
}

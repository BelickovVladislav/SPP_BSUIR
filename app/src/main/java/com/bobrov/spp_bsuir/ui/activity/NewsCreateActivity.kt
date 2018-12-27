package com.bobrov.spp_bsuir.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bobrov.spp_bsuir.entity.News
import com.bobrov.spp_bsuir.R
import com.bobrov.spp_bsuir.repository.ScopeRepository
import kotlinx.android.synthetic.main.activity_news_create.*
import com.bobrov.spp_bsuir.entity.Scope
import com.bobrov.spp_bsuir.repository.NewsRepository


class NewsCreateActivity : AppCompatActivity() {

    private val scopeRepository = ScopeRepository()
    private val newsRepository = NewsRepository()

    private lateinit var scopes: List<Scope>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_create)
        supportActionBar?.setTitle(R.string.create_news)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        scopeRepository.getAll {
            scopes = it
            newsCreateSpinner.adapter = ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, it.map { it.name })
        }
    }

    @SuppressLint("StringFormatMatches")
    private fun showAlertEmptyText(typeProperty: Int) {
        Toast.makeText(this, getString(R.string.not_empty_property,
                getString(typeProperty).toLowerCase()), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_create, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_object -> {
                if (newsCreateTitle.text.isEmpty()) {
                    showAlertEmptyText(R.string.title)
                    return super.onOptionsItemSelected(item)
                }
                if (newsCreateDescription.text.isEmpty()) {
                    showAlertEmptyText(R.string.description)
                    return super.onOptionsItemSelected(item)
                }
            }
        }
        saveNews()
        Toast.makeText(this, R.string.success_news_create, Toast.LENGTH_SHORT).show()
        finish()
        return super.onOptionsItemSelected(item)
    }

    private fun saveNews() {
        val news = News()
        val scopeName = newsCreateSpinner.selectedItem.toString()
        news.scopeId = scopes.first { it.name == scopeName }.id
        news.title = newsCreateTitle.text.toString()
        news.description = newsCreateDescription.text.toString()
        newsRepository.add(news)
    }
}

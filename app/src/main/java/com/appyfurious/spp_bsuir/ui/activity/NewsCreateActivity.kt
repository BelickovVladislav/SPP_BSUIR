package com.appyfurious.spp_bsuir.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.appyfurious.spp_bsuir.R

class NewsCreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_create)
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
                //TODO save DB
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

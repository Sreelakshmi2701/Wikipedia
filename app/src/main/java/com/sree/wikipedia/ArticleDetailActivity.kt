package com.sree.wikipedia

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem


import androidx.appcompat.app.AppCompatActivity


class ArticleDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
         var mToolbar: androidx.appcompat.widget.Toolbar? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        mToolbar=findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId==android.R.id.home){
            finish()
        }
        return true;
    }
}
package com.sree.wikipedia

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.sree.wikipedia.models.WikiPage
import kotlinx.android.synthetic.main.activity_article_detail.*


class ArticleDetailActivity : AppCompatActivity() {

    private var currentPage: WikiPage?=null
    override fun onCreate(savedInstanceState: Bundle?) {
         var mToolbar: androidx.appcompat.widget.Toolbar? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        mToolbar=findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val wikiPageJson =intent.getStringExtra("page")
        currentPage= Gson().fromJson<WikiPage>(wikiPageJson,WikiPage::class.java)
        article_detail_webview?.webViewClient=object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?,request: WebResourceRequest? ): Boolean {
                return true

            }
        }
        article_detail_webview.loadUrl(currentPage!!.fullurl)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId==android.R.id.home){
            finish()
        }
        return true;
    }
}
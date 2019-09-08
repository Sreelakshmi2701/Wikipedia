package com.sree.wikipedia

import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.sree.wikipedia.models.WikiPage
import kotlinx.android.synthetic.main.activity_article_detail.*

import android.view.View
import kotlinx.android.synthetic.main.article_list_item.*


class ArticleDetailActivity : AppCompatActivity() {

    private var currentPage: WikiPage?=null
    var button01pos = 0
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
        setonClickListner()
    }

    private fun setonClickListner() {
        imgFavIcon.setOnTouchListener(object : View.OnTouchListener {
            internal var button01pos = 0
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if (button01pos == 0) {
                    imgFavIcon.setImageResource(R.drawable.fav_icon_empty);
                    button01pos = 1;
                    MyApplication.usersFavouriteArticles.remove(currentPage?.pageid.toString())
                } else if (button01pos == 1) {
                    imgFavIcon.setImageResource(R.drawable.fav_icon_filled);
                    button01pos = 0;
                    MyApplication.usersFavouriteArticles.put(currentPage?.pageid.toString(),currentPage)
                }
                return true;
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId==android.R.id.home){
            finish()
        }
        return true;
    }
}
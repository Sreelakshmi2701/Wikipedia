package com.sree.wikipedia

import android.annotation.TargetApi
import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sree.wikipedia.adapters.ArticleCardRecyclerAdapter
import com.sree.wikipedia.adapters.ArticleListRecyclerAdapter
import com.sree.wikipedia.models.WikiSearchResult
import com.sree.wikipedia.providers.ArticleDataProvider
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_explore.*

class SearchActivity : AppCompatActivity() {
    private val articleDataProvider=com.sree.wikipedia.providers.ArticleDataProvider()
private var adapter :ArticleCardRecyclerAdapter = ArticleCardRecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        var mToolbar: androidx.appcompat.widget.Toolbar? = null
        mToolbar=findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        var searchRecycler: RecyclerView= findViewById<RecyclerView>(R.id.search_result_recyclerview)
        searchRecycler.layoutManager= LinearLayoutManager(this)
        searchRecycler.adapter=adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item!!.itemId==android.R.id.home){
            finish()
        }
        return true
    }
    @TargetApi(24)
    override fun onCreateOptionsMenu(menu: Menu?) :Boolean{
     menuInflater.inflate(R.menu.search_menu,menu)
        val searchItem=menu!!.findItem(R.id.app_bar_search)
        val searchManager=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView= searchItem!!.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
        searchView.requestFocus()
      searchView.setOnQueryTextListener(
          object: SearchView.OnQueryTextListener{
              override fun onQueryTextSubmit(query: String): Boolean {
                  articleDataProvider.search(query,0,5) { WikiSearchResult ->
                      //adapter  = ArticleListRecyclerAdapter()
                      adapter.currentResults.clear()
                      adapter.currentResults.addAll(WikiSearchResult.query!!.pages)
                      runOnUiThread { adapter.notifyDataSetChanged()
                          refresher?.isRefreshing = true}
                  }
                  println("updated search")
                  return false
              }
              override fun onQueryTextChange(s: String): Boolean{
                  return false
              }
          })
        return super.onCreateOptionsMenu(menu)
    }
}

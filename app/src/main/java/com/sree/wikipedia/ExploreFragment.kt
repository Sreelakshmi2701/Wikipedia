package com.sree.wikipedia


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sree.wikipedia.adapters.ArticleCardRecyclerAdapter
import com.sree.wikipedia.adapters.ArticleListRecyclerAdapter
import com.sree.wikipedia.providers.ArticleDataProvider
import kotlinx.android.synthetic.main.fragment_explore.*

/**
 * A simple [Fragment] subclass.
 */
class ExploreFragment : Fragment() {
    private val articleProvider: ArticleDataProvider = ArticleDataProvider()
    var searchCardView: CardView? = null
    var exploreRecycler: RecyclerView? = null
    var adapter: ArticleListRecyclerAdapter = ArticleListRecyclerAdapter()
    var refresher: SwipeRefreshLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_explore, container, false)
        searchCardView = view.findViewById<CardView>(R.id.search_card_view)
        exploreRecycler = view.findViewById<RecyclerView>(R.id.explore_recycler)
        refresher = view.findViewById<SwipeRefreshLayout>(R.id.refresher)
        searchCardView!!.setOnClickListener {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context!!.startActivity(searchIntent)
        }
        exploreRecycler!!.layoutManager = LinearLayoutManager(context)
        exploreRecycler!!.adapter = adapter
        refresher?.setOnRefreshListener {
            refresher?.isRefreshing = true
            getRandomArticles()
        }
        getRandomArticles()
        return view
    }

    private fun getRandomArticles() {
        refresher?.isRefreshing = true
        try {
            articleProvider.getRandom(25, { wikiResult ->
                adapter.currentResults.clear()
                adapter.currentResults.addAll(wikiResult.query!!.pages.values)
                activity?.runOnUiThread {
                    adapter.notifyDataSetChanged()
                    refresher?.isRefreshing = false
                }
            })
        }
        catch(ex : Exception){
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(ex.message).setTitle("oops!")
            val dialog = builder.create()
            dialog.show()

        }
    }
}

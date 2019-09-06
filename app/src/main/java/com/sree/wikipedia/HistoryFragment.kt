package com.sree.wikipedia


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sree.wikipedia.adapters.ArticleCardRecyclerAdapter
import com.sree.wikipedia.adapters.ArticleListRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_history.*

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment() {
    val  articleCardRecyclerAdapter =ArticleCardRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_history, container, false)
        var hisRecycler= view.findViewById<RecyclerView>(R.id.history_article_recycler)
        hisRecycler.layoutManager=LinearLayoutManager(context)
        hisRecycler.adapter= articleCardRecyclerAdapter
        articleCardRecyclerAdapter.currentResults.addAll(MyApplication.userVisitedArticles)
        articleCardRecyclerAdapter.notifyDataSetChanged()
        return view
    }


}

package com.sree.wikipedia


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sree.wikipedia.adapters.ArticleCardRecyclerAdapter
import com.sree.wikipedia.adapters.ArticleListRecyclerAdapter
import com.sree.wikipedia.models.WikiPage
import kotlinx.android.synthetic.main.fragment_favourites.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class favouritesFragment : Fragment() {
    val  articleCardRecyclerAdapter =ArticleCardRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_favourites, container, false)
        var favRecycler= view.findViewById<RecyclerView>(R.id.favourites_article_recycler)
        favRecycler.layoutManager=LinearLayoutManager(context)
        favRecycler.adapter= articleCardRecyclerAdapter
        articleCardRecyclerAdapter.currentResults.clear()
       // val listOfFav: Collection<WikiPage> = MyApplication.usersFavouriteArticles.values

        MyApplication.usersFavouriteArticles.values.forEach {
            articleCardRecyclerAdapter.currentResults.add(it)
        }
        //articleCardRecyclerAdapter.currentResults.add(it)
        articleCardRecyclerAdapter.notifyDataSetChanged()

        return view
    }


}

package com.sree.wikipedia


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sree.wikipedia.adapters.ArticleCardRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_explore.*

/**
 * A simple [Fragment] subclass.
 */
class ExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_explore, container, false)
        search_card_view.setOnClickListener{
            val searchIntent= Intent(context,SearchActivity::class.java)
            context!!.startActivity(searchIntent)
        }
        explore_recycler.layoutManager= LinearLayoutManager(context)
        explore_recycler.adapter=ArticleCardRecyclerAdapter()
        return view
    }


}

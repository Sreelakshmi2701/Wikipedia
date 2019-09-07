package com.sree.wikipedia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sree.wikipedia.Holders.CardHolder
import com.sree.wikipedia.Holders.ListHolder
import com.sree.wikipedia.models.WikiPage
import com.sree.wikipedia.R

class ArticleListRecyclerAdapter() : RecyclerView.Adapter<ListHolder>() {
    val currentResults: ArrayList<WikiPage> = ArrayList<WikiPage>()
    override fun getItemCount(): Int {
        return currentResults.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        var page= currentResults[position]
        holder?.updateWithPage(page)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        var cardItem= LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item,parent,false)
        return ListHolder(cardItem)
    }
}
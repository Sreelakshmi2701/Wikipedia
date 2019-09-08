package com.sree.wikipedia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sree.wikipedia.Holders.CardHolder
import com.sree.wikipedia.models.WikiPage
import com.sree.wikipedia.R

class ArticleCardRecyclerAdapter() : RecyclerView.Adapter<CardHolder>() {
    val currentResults: ArrayList<WikiPage> = ArrayList<WikiPage>()
    override fun getItemCount(): Int {
        return currentResults.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        var page= currentResults[position]
        //holder?.updateWithPage(page)
        holder?.updateWithPage(page)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        var cardItem= LayoutInflater.from(parent?.context).inflate(R.layout.article_card_item,parent,false)
        return CardHolder(cardItem)
    }
}
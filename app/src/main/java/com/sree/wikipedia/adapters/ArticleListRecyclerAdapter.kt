package com.sree.wikipedia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sree.wikipedia.Holders.CardHolder
import com.sree.wikipedia.R

class ArticleListRecyclerAdapter() : RecyclerView.Adapter<CardHolder>() {
    override fun getItemCount(): Int {
        return 15
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        var cardItem= LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item,parent,false)
        return CardHolder(cardItem)
    }
}
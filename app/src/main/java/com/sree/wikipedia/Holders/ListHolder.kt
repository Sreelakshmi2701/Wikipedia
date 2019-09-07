package com.sree.wikipedia.Holders

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.sree.wikipedia.ArticleDetailActivity
import com.sree.wikipedia.MyApplication
import com.sree.wikipedia.models.WikiPage
import com.sree.wikipedia.R

class ListHolder (itemView: View): RecyclerView.ViewHolder(itemView){
private val articleImageView: ImageView=itemView.findViewById<ImageView>(R.id.result_icon)
    private val titleTextView: TextView=itemView.findViewById<TextView>(R.id.result_title)

    private var currentPage: WikiPage? = null

    init{
        itemView.setOnClickListener{ view: View? ->
            MyApplication.userVisitedArticles.add(currentPage)
            var detailPageIntent= Intent(itemView.context, ArticleDetailActivity::class.java)
            var pageJson = Gson().toJson(currentPage)
            detailPageIntent.putExtra("page",pageJson)
            itemView.context.startActivity(detailPageIntent)
        }
    }
    fun updateWithPage(page: WikiPage){
        currentPage=page
        titleTextView.text =page.title
        if(page.thumbnail!=null){
            Picasso.with(itemView.context).load(page.thumbnail!!.source).into(articleImageView)
        }

    }
}
package com.sree.wikipedia.Holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sree.wikipedia.R
import kotlinx.android.synthetic.main.article_card_item.view.*

class ListHolder (itemView: View): RecyclerView.ViewHolder(itemView){
private val articleImageView: ImageView=itemView.findViewById<ImageView>(R.id.result_icon)
    private val titleTextView: TextView=itemView.findViewById<TextView>(R.id.result_title)
}
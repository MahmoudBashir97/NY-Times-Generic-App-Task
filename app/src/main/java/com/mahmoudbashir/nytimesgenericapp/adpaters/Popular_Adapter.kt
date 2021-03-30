package com.mahmoudbashir.nytimesgenericapp.adpaters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudbashir.nytimesgenericapp.R
import com.mahmoudbashir.nytimesgenericapp.interfaces.ItemClickInterface
import com.mahmoudbashir.nytimesgenericapp.pojo.results

class Popular_Adapter(val context: Context, private val itemClickInterface: ItemClickInterface): RecyclerView.Adapter<Popular_Adapter.ViewHolder>() {

    inner class ViewHolder(item:View): RecyclerView.ViewHolder(item) {
        val title: TextView = item.findViewById<TextView>(R.id.txt_article_title)
        val byLine: TextView = item.findViewById<TextView>(R.id.txt_content_writer)
        val publishedDate: TextView = item.findViewById<TextView>(R.id.txt_date)
    }

    private val differCallback = object : DiffUtil.ItemCallback<results>(){
        override fun areItemsTheSame(oldItem: results, newItem: results): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: results, newItem: results): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_item_times_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = differ.currentList[position].title
        holder.byLine.text = differ.currentList[position].byline
        holder.publishedDate.text = differ.currentList[position].published_date

        holder.itemView.setOnClickListener {
            val title = differ.currentList[position].title

            val imgUrl = if (differ.currentList[position].media.isNotEmpty()){
                differ.currentList[position].media[0].media_metadata[0].url
            }else{
                "R.drawable.ic_launcher_background"
            }
            val articleabstract = differ.currentList[position].abstract
            itemClickInterface.onClick(position,imgUrl,title,articleabstract)
        }
    }

    override fun getItemCount()= differ.currentList.size

}
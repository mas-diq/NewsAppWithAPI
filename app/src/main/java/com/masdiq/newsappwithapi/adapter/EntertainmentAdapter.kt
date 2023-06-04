package com.masdiq.newsappwithapi.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masdiq.newsappwithapi.DetailActivity
import com.masdiq.newsappwithapi.databinding.NewsLayoutBinding
import com.masdiq.newsappwithapi.model.Result

class EntertainmentAdapter : RecyclerView.Adapter<EntertainmentAdapter.ViewHolder>() {

    private var entertainmentList = ArrayList<Result>()

    fun setEntertainmentList(entertainmentList: List<Result>) {
        this.entertainmentList = entertainmentList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val entertainmentBinding: NewsLayoutBinding) :
        RecyclerView.ViewHolder(entertainmentBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NewsLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(entertainmentList[position].urlToImage)
            .into(holder.entertainmentBinding.newsImage)
        with(holder.entertainmentBinding) {
            newsTitle.text = entertainmentList[position].title
            newsAuthor.text = entertainmentList[position].author
            newsPublished.text = entertainmentList[position].source!!.name
        }
        holder.itemView.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val move = Intent(activity, DetailActivity::class.java)
            move.putExtra("img", entertainmentList[position].urlToImage.toString())
            move.putExtra("source", entertainmentList[position].source!!.name)
            move.putExtra("author", entertainmentList[position].author)
            move.putExtra("title", entertainmentList[position].title)
            move.putExtra("desc", entertainmentList[position].description.toString())
            move.putExtra("content", entertainmentList[position].content.toString())
            move.putExtra("published", entertainmentList[position].publishedAt)
            move.putExtra("link", entertainmentList[position].url)
            activity.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return entertainmentList.size
    }
}
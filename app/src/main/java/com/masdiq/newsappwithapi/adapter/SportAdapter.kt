package com.masdiq.newsappwithapi.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masdiq.newsappwithapi.ui.main.DetailActivity
import com.masdiq.newsappwithapi.databinding.NewsLayoutBinding
import com.masdiq.newsappwithapi.model.Result

class SportAdapter : RecyclerView.Adapter<SportAdapter.ViewHolder>() {

    private var sportList = ArrayList<Result>()

    fun setSportList(sportList: List<Result>) {
        this.sportList = sportList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val sportBinding: NewsLayoutBinding) :
        RecyclerView.ViewHolder(sportBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportAdapter.ViewHolder {
        return ViewHolder(NewsLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SportAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(sportList[position].urlToImage)
            .into(holder.sportBinding.newsImage)
        with(holder.sportBinding) {
            newsTitle.text = sportList[position].title
            newsAuthor.text = sportList[position].author
            newsPublished.text = sportList[position].source!!.name
        }
        holder.itemView.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val move = Intent(activity, DetailActivity::class.java)
            move.putExtra("img", sportList[position].urlToImage.toString())
            move.putExtra("source", sportList[position].source!!.name)
            move.putExtra("author", sportList[position].author)
            move.putExtra("title", sportList[position].title)
            move.putExtra("desc", sportList[position].description.toString())
            move.putExtra("published", sportList[position].publishedAt)
            move.putExtra("link", sportList[position].url)
            activity.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return sportList.size
    }
}
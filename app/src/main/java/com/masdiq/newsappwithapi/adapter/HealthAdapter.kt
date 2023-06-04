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

class HealthAdapter : RecyclerView.Adapter<HealthAdapter.ViewHolder>() {

    private var healthList = ArrayList<Result>()

    fun setHealthList(healthList: List<Result>) {
        this.healthList = healthList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val healthBinding: NewsLayoutBinding) :
        RecyclerView.ViewHolder(healthBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NewsLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(healthList[position].urlToImage)
            .into(holder.healthBinding.newsImage)
        with(holder.healthBinding) {
            newsTitle.text = healthList[position].title
            newsAuthor.text = healthList[position].author
            newsPublished.text = healthList[position].source!!.name
        }
        holder.itemView.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val move = Intent(activity, DetailActivity::class.java)
            move.putExtra("img", healthList[position].urlToImage.toString())
            move.putExtra("source", healthList[position].source!!.name)
            move.putExtra("author", healthList[position].author)
            move.putExtra("title", healthList[position].title)
            move.putExtra("desc", healthList[position].description.toString())
            move.putExtra("published", healthList[position].publishedAt)
            move.putExtra("link", healthList[position].url)
            activity.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return healthList.size
    }
}
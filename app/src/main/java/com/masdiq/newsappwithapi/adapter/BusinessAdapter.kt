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

class BusinessAdapter : RecyclerView.Adapter<BusinessAdapter.ViewHolder>() {

    private var businessList = ArrayList<Result>()

    fun setBusinessList(businessList: List<Result>) {
        this.businessList = businessList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val businessBinding: NewsLayoutBinding) :
        RecyclerView.ViewHolder(businessBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessAdapter.ViewHolder {
        return ViewHolder(NewsLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BusinessAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(businessList[position].urlToImage)
            .into(holder.businessBinding.newsImage)
        with(holder.businessBinding) {
            newsTitle.text = businessList[position].title
            newsAuthor.text = businessList[position].author
            newsPublished.text = businessList[position].source!!.name
        }
        holder.itemView.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val move = Intent(activity, DetailActivity::class.java)
            move.putExtra("img", businessList[position].urlToImage.toString())
            move.putExtra("source", businessList[position].source!!.name)
            move.putExtra("author", businessList[position].author)
            move.putExtra("title", businessList[position].title)
            move.putExtra("desc", businessList[position].description.toString())
            move.putExtra("published", businessList[position].publishedAt)
            move.putExtra("link", businessList[position].url)
            activity.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return businessList.size
    }
}
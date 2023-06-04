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

class GeneralAdapter : RecyclerView.Adapter<GeneralAdapter.ViewHolder>() {

    private var generalList = ArrayList<Result>()

    fun setGeneralList(generalList: List<Result>) {
        this.generalList = generalList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val generalBinding: NewsLayoutBinding) :
        RecyclerView.ViewHolder(generalBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneralAdapter.ViewHolder {
        return ViewHolder(NewsLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: GeneralAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(generalList[position].urlToImage)
            .into(holder.generalBinding.newsImage)
        with(holder.generalBinding) {
            newsTitle.text = generalList[position].title
            newsAuthor.text = generalList[position].author
            newsPublished.text = generalList[position].source!!.name
        }
        holder.itemView.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val move = Intent(activity, DetailActivity::class.java)
            move.putExtra("img", generalList[position].urlToImage.toString())
            move.putExtra("source", generalList[position].source!!.name)
            move.putExtra("author", generalList[position].author)
            move.putExtra("title", generalList[position].title)
            move.putExtra("desc", generalList[position].description.toString())
            move.putExtra("content", generalList[position].content.toString())
            move.putExtra("published", generalList[position].publishedAt)
            move.putExtra("link", generalList[position].url)
            activity.startActivity(move)
        }
    }

    override fun getItemCount(): Int {
        return generalList.size
    }
}
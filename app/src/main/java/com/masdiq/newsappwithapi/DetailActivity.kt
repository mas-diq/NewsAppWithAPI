package com.masdiq.newsappwithapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.masdiq.newsappwithapi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val img = intent.extras?.getString("img") ?: "Null"
        val source = intent.extras?.getString("source") ?: "Null"
        val author = intent.extras?.getString("author") ?: "Null"
        val title = intent.extras?.getString("title") ?: "Null"
        val desc = intent.extras?.getString("desc") ?: "Null"
        val content = intent.extras?.getString("content") ?: "Null"
        val published = intent.extras?.getString("published") ?: "Null"
        val data = intent.extras?.getString("link") ?: "Null"

        Glide.with(binding.imageViewNews)
            .load(img)
            .into(binding.imageViewNews)
        with(binding) {
            txtSource.text = source
            txtAuthor.text = author
            txtTitle.text = title
            txtDesc.text = desc
            txtContent.text = content
            txtPublished.text = published
        }

        binding.button.setOnClickListener {
            val move = Intent(this, WebViewActivity::class.java)
            move.putExtra("link", data)
            startActivity(move)
        }

    }
}
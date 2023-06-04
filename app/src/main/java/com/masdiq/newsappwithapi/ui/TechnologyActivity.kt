package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.newsappwithapi.databinding.ActivityTechnologyBinding

class TechnologyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTechnologyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechnologyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
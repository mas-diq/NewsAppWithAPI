package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.newsappwithapi.databinding.ActivitySportBinding

class SportActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
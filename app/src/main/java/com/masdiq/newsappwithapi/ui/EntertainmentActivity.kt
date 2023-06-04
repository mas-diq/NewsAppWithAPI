package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.newsappwithapi.databinding.ActivityEntertainmentBinding

class EntertainmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntertainmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntertainmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.newsappwithapi.databinding.ActivityBusinessBinding

class BusinessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBusinessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
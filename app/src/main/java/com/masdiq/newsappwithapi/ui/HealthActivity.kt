package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.newsappwithapi.adapter.HealthAdapter
import com.masdiq.newsappwithapi.databinding.ActivityHealthBinding
import com.masdiq.newsappwithapi.viewmodel.HealthViewModel

class HealthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHealthBinding
    private lateinit var viewModel: HealthViewModel
    private lateinit var healthAdapter: HealthAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[HealthViewModel::class.java]
        viewModel.getHealth()
        viewModel.observeHealthLiveData().observe(this, Observer { newsList ->
            healthAdapter.setHealthList(newsList)
        })
    }

    private fun prepareRecyclerView() {
        healthAdapter = HealthAdapter()
        binding.rvHealth.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = healthAdapter
        }
    }
}
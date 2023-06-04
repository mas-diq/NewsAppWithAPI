package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.newsappwithapi.adapter.BusinessAdapter
import com.masdiq.newsappwithapi.databinding.ActivityBusinessBinding
import com.masdiq.newsappwithapi.viewmodel.BusinessViewModel

class BusinessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBusinessBinding
    private lateinit var viewModel: BusinessViewModel
    private lateinit var businessAdapter: BusinessAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[BusinessViewModel::class.java]
        viewModel.getBusiness()
        viewModel.observeBusinessLiveData().observe(this, Observer { newsList ->
            businessAdapter.setBusinessList(newsList)
        })

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun prepareRecyclerView() {
        businessAdapter = BusinessAdapter()
        binding.rvBusiness.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = businessAdapter
        }
    }
}
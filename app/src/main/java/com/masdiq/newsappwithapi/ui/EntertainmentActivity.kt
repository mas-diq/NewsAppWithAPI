package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.newsappwithapi.adapter.EntertainmentAdapter
import com.masdiq.newsappwithapi.databinding.ActivityEntertainmentBinding
import com.masdiq.newsappwithapi.viewmodel.EntertainmentViewModel

class EntertainmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEntertainmentBinding
    private lateinit var viewModel: EntertainmentViewModel
    private lateinit var entertainmentAdapter: EntertainmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntertainmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[EntertainmentViewModel::class.java]
        viewModel.getEntertainment()
        viewModel.observeEntertainmentLiveData().observe(this, Observer { newsList ->
            entertainmentAdapter.setEntertainmentList(newsList)
        })
    }

    private fun prepareRecyclerView() {
        entertainmentAdapter = EntertainmentAdapter()
        binding.rvEntertainment.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = entertainmentAdapter
        }
    }
}
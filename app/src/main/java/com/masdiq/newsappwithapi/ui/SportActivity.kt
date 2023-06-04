package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.newsappwithapi.adapter.SportAdapter
import com.masdiq.newsappwithapi.databinding.ActivitySportBinding
import com.masdiq.newsappwithapi.viewmodel.SportViewModel

class SportActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySportBinding
    private lateinit var viewModel: SportViewModel
    private lateinit var sportAdapter: SportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[SportViewModel::class.java]
        viewModel.getSport()
        viewModel.observeSportLiveData().observe(this, Observer { newsList ->
            sportAdapter.setSportList(newsList)
        })
    }

    private fun prepareRecyclerView() {
        sportAdapter = SportAdapter()
        binding.rvSport.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = sportAdapter
        }
    }
}
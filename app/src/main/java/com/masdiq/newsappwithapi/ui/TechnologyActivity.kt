package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.newsappwithapi.adapter.TechnologyAdapter
import com.masdiq.newsappwithapi.databinding.ActivityTechnologyBinding
import com.masdiq.newsappwithapi.viewmodel.TechnologyViewModel

class TechnologyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTechnologyBinding
    private lateinit var viewModel: TechnologyViewModel
    private lateinit var technologyAdapter: TechnologyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechnologyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[TechnologyViewModel::class.java]
        viewModel.getTechnology()
        viewModel.observeTechnologyLiveData().observe(this, Observer { newsList ->
            technologyAdapter.setTechnologyList(newsList)
        })
    }

    private fun prepareRecyclerView() {
        technologyAdapter = TechnologyAdapter()
        binding.rvTechnology.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = technologyAdapter
        }
    }
}
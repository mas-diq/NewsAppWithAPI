package com.masdiq.newsappwithapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masdiq.newsappwithapi.adapter.GeneralAdapter
import com.masdiq.newsappwithapi.databinding.ActivityGeneralBinding
import com.masdiq.newsappwithapi.viewmodel.GeneralViewModel

class GeneralActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGeneralBinding
    private lateinit var viewModel: GeneralViewModel
    private lateinit var generalAdapter: GeneralAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[GeneralViewModel::class.java]
        viewModel.getGeneral()
        viewModel.observeGeneralLiveData().observe(this, Observer { newsList ->
            generalAdapter.setGeneralList(newsList)
        })
    }

    private fun prepareRecyclerView() {
        generalAdapter = GeneralAdapter()
        binding.rvGeneral.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = generalAdapter
        }
    }
}
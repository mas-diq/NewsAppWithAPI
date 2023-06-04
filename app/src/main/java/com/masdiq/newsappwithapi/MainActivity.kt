package com.masdiq.newsappwithapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masdiq.newsappwithapi.databinding.ActivityMainBinding
import com.masdiq.newsappwithapi.ui.BusinessActivity
import com.masdiq.newsappwithapi.ui.EntertainmentActivity
import com.masdiq.newsappwithapi.ui.GeneralActivity
import com.masdiq.newsappwithapi.ui.HealthActivity
import com.masdiq.newsappwithapi.ui.SportActivity
import com.masdiq.newsappwithapi.ui.TechnologyActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moveAct()
    }

    private fun moveAct() {
        binding.imgGeneral.setOnClickListener {
            val move = Intent(this, GeneralActivity::class.java)
            startActivity(move)
        }

        binding.imgBusiness.setOnClickListener {
            val move = Intent(this, BusinessActivity::class.java)
            startActivity(move)
        }

        binding.imgEntertainment.setOnClickListener {
            val move = Intent(this, EntertainmentActivity::class.java)
            startActivity(move)
        }

        binding.imgHealth.setOnClickListener {
            val move = Intent(this, HealthActivity::class.java)
            startActivity(move)
        }

        binding.imgSport.setOnClickListener {
            val move = Intent(this, SportActivity::class.java)
            startActivity(move)
        }

        binding.imgTechnology.setOnClickListener {
            val move = Intent(this, TechnologyActivity::class.java)
            startActivity(move)
        }

        binding.imgGit.setOnClickListener() {
            val move = Intent(this, WebViewActivity::class.java)
            move.putExtra("link", "https://github.com/mas-diq")
            startActivity(move)
        }
    }
}
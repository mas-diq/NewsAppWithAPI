package com.masdiq.newsappwithapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masdiq.newsappwithapi.API_KEY
import com.masdiq.newsappwithapi.model.News
import com.masdiq.newsappwithapi.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val key = API_KEY

class BusinessViewModel : ViewModel() {

    private var businessLiveData = MutableLiveData<List<Result>>()

    fun getBusiness() {
        RetrofitInstance.businessApi.getBusiness(key).enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.body() !== null) {
                    businessLiveData.value = response.body()!!.articles
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }
        })
    }

    fun observeBusinessLiveData(): LiveData<List<Result>> {
        return businessLiveData
    }
}
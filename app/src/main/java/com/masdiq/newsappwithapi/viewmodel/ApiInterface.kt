package com.masdiq.newsappwithapi.viewmodel

import com.masdiq.newsappwithapi.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeneralApi {
    @GET("top-headlines?country=us&category=general&apiKey?")
    fun getGeneral(@Query("apiKey") api_key:String) : Call<News>
}

interface BusinessApi {
    @GET("top-headlines?country=us&category=business&apiKey?")
    fun getGeneral(@Query("apiKey") api_key:String) : Call<News>
}

interface EntertainmentApi {
    @GET("top-headlines?country=us&category=entertainment&apiKey?")
    fun getGeneral(@Query("apiKey") api_key:String) : Call<News>
}

interface HealthApi {
    @GET("top-headlines?country=us&category=health&apiKey?")
    fun getGeneral(@Query("apiKey") api_key:String) : Call<News>
}

interface SportApi {
    @GET("top-headlines?country=us&category=sport&apiKey?")
    fun getGeneral(@Query("apiKey") api_key:String) : Call<News>
}

interface TechnologyApi {
    @GET("top-headlines?country=us&category=technology&apiKey?")
    fun getGeneral(@Query("apiKey") api_key:String) : Call<News>
}
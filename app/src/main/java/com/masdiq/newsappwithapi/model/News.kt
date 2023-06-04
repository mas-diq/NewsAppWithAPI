package com.masdiq.newsappwithapi.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    val articles: List<Result>,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)
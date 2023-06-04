package com.masdiq.newsappwithapi.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: Any?,
    @SerializedName("description")
    val description: Any?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("source")
    val source: Source?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: Any?
)
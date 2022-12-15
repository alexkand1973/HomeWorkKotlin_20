package com.alexkand.homeworkkotlin_20.data.network.retrofit.services

import com.alexkand.homeworkkotlin_20.data.network.retrofit.models.Image
import retrofit2.Call
import retrofit2.http.GET

interface ImageServices {

    @GET("images/search")
    fun getImage(): Call<List<Image>>
}
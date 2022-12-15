package com.alexkand.homeworkkotlin_20.data.network.retrofit.clients

import com.alexkand.homeworkkotlin_20.data.network.retrofit.services.ImageServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ImageClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ImageServices:: class.java)
}
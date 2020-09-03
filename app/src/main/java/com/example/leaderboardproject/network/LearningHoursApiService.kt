package com.example.leaderboardproject.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//Define BASE_Url
private const val BASE_URL = "https://gadsapi.herokuapp.com/"

//Retrofit
private  val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface LearningHoursApiService {
    @GET("api/hours")
    fun getProperties(): Call<String>
}

//Object to initialize the Retrofit service.
object LearningHoursApi{
    val retrofitService : LearningHoursApiService by lazy {
        retrofit.create(LearningHoursApiService::class.java)
    }
}
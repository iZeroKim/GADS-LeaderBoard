package com.example.leaderboardproject.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

import retrofit2.http.GET

//Define BASE_Url
private const val BASE_URL = "https://gadsapi.herokuapp.com/api/"

//Retrofit
private  val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

interface LearningHoursApiService {
    @GET("hours")
    fun getProperties(): Call<String>
}

//Object to initialize the Retrofit service.
object LearningHoursApi{
    val retrofitService : LearningHoursApiService by lazy {
        retrofit.create(LearningHoursApiService::class.java)
    }
}
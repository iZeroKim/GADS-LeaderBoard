package com.example.leaderboardproject.network.learninghours

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


import retrofit2.http.GET


//Define BASE_Url
private const val BASE_URL = "https://gadsapi.herokuapp.com/api/"

//Moshi
private val moshi = Moshi.Builder()
        //Use this with annotations
    .add(KotlinJsonAdapterFactory())
    .build()

//Retrofit
private  val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface LearningHoursApiService {
    @GET("hours")
    suspend fun getProperties(): List<LearnerDetails>
}

//Object to initialize the Retrofit service.
object LearningHoursApi{
    val retrofitService : LearningHoursApiService by lazy {
        retrofit.create(LearningHoursApiService::class.java)
    }
}
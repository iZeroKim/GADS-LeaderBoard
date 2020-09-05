package com.example.leaderboardproject.network.skilliq

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

interface SkillIQApiService {
    @GET("skilliq")
    suspend fun getProperties(): List<LearnerIQDetails>
}

//Object to initialize the Retrofit service.
object SkillIQApi{
    val retrofitService : SkillIQApiService by lazy {
        retrofit.create(SkillIQApiService::class.java)
    }
}
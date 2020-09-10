package com.example.leaderboardproject.network.submission

import com.example.leaderboardproject.network.skilliq.LearnerIQDetails
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


//Define BASE_Url
private const val BASE_URL = "https://docs.google.com/forms/d/e/"

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

interface SubmitApi {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitproject(
        @Field("entry.1877115667")firstName: String,
        @Field("entry.2006916086")lastName: String,
        @Field("entry.1824927963")emailAddress: String,
        @Field("entry.284483984")githubLink: String
    ): Call<Void>
}

//Object to initialize the Retrofit service.
object SubmitProjectApi{
    val retrofitService : SubmitApi by lazy {
        retrofit.create(SubmitApi::class.java)
    }
}
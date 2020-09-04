package com.example.leaderboardproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.leaderboardproject.network.LearningHoursApi
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LearningHoursViewModel : ViewModel() {
    //
    // single Mars Property LiveData (internal mutable and external immutable)
    private val _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text

    init {
        getLearningHoursLeaders()
    }
    private fun getLearningHoursLeaders(){
        LearningHoursApi.retrofitService.getProperties().enqueue(
            object : retrofit2.Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    _text.value = response.body().toString()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                   _text.value = "Failure: " + t.message
                }

            }
        )

    }
}
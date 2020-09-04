package com.example.leaderboardproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leaderboardproject.network.LearnerDetails
import com.example.leaderboardproject.network.LearningHoursApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import javax.security.auth.callback.Callback

class LearningHoursViewModel : ViewModel() {
    // Coroutines
    //private var viewModelJob = Job()
    //private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    // single Mars Property LiveData (internal mutable and external immutable)
    private val _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text

    init {
        getLearningHoursLeaders()
    }

    private fun getLearningHoursLeaders() {
        viewModelScope.launch {
            try {
                val resultList = LearningHoursApi.retrofitService.getProperties()
                _text.value = resultList.toString()
            } catch (e: Exception ){
                _text.value = "Failure: ${e.message}"
            }
        }
    }


}
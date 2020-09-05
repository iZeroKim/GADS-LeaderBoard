package com.example.leaderboardproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leaderboardproject.network.learninghours.LearningHoursApi
import kotlinx.coroutines.launch
import java.lang.Exception

class LearningHoursViewModel : ViewModel() {
    // Coroutines
    //private var viewModelJob = Job()
    //private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    // single Learner Detail LiveData (internal mutable and external immutable)
    private val _name = MutableLiveData<String>()

    val name: LiveData<String>
        get() = _name


    init {
        getLearningHoursLeaders()
    }

    private fun getLearningHoursLeaders() {
        viewModelScope.launch {
            try {
                val resultList = LearningHoursApi.retrofitService.getProperties()
                _name.value = resultList.toString()

            } catch (e: Exception ){
                _name.value = "Failure: ${e.message}"
            }
        }
    }


}
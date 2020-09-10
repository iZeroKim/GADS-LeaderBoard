package com.example.leaderboardproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leaderboardproject.network.learninghours.LearnerDetails
import com.example.leaderboardproject.network.skilliq.LearnerIQDetails
import com.example.leaderboardproject.network.skilliq.SkillIQApi

import kotlinx.coroutines.launch
import java.lang.Exception

class SkillIqViewModel : ViewModel() {
    // single Learner Detail LiveData (internal mutable and external immutable)
    private val _learners = MutableLiveData<List<LearnerIQDetails>>()

    val learners: LiveData<List<LearnerIQDetails>>
        get() = _learners

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getSkillIQLeaders()
    }

    private fun getSkillIQLeaders() {
        viewModelScope.launch {
            try {
                val resultList = SkillIQApi.retrofitService.getProperties()
                _learners.value = resultList

            } catch (e: Exception){
                _response.value = "Failure: ${e.message}"
            }
        }
    }

}
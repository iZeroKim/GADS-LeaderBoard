package com.example.leaderboardproject

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.leaderboardproject.network.learninghours.LearnerDetails
import com.example.leaderboardproject.network.learninghours.LearningHoursApi
import com.example.leaderboardproject.network.skilliq.SkillIQApi
import kotlinx.coroutines.launch
import java.lang.Exception

class LearningHoursViewModel : ViewModel() {
    // single Learner Detail LiveData (internal mutable and external immutable)
    private val _learners = MutableLiveData<List<LearnerDetails>>()

    val learners: LiveData<List<LearnerDetails>>
        get() = _learners

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getLearningHoursLeaders()
    }

    private fun getLearningHoursLeaders() {
        viewModelScope.launch {
            try {
                val resultList = LearningHoursApi.retrofitService.getProperties()
                _learners.value = resultList

            } catch (e: Exception){
               _response.value = "Failure: ${e.message}"
            }
        }
    }


}
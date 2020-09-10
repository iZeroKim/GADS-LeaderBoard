package com.example.leaderboardproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leaderboardproject.network.skilliq.SkillIQApi

import kotlinx.coroutines.launch
import java.lang.Exception

class SkillIqViewModel : ViewModel() {
    // single Learner Detail LiveData (internal mutable and external immutable)
    private val _name = MutableLiveData<String>()

    val name: LiveData<String>
        get() = _name


    init {
        getSkillIQLeaders()
    }

    private fun getSkillIQLeaders() {
        viewModelScope.launch {
            try {
                val resultList = SkillIQApi.retrofitService.getProperties()
                _name.value = resultList[0].toString()

            } catch (e: Exception){
                _name.value = "Failure: ${e.message}"
            }
        }
    }

}
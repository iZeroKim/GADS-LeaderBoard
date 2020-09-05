package com.example.leaderboardproject

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.leaderboardproject.databinding.LearningHoursFragmentBinding
import com.example.leaderboardproject.databinding.SkillIqFragmentBinding

class SkillIqFragment : Fragment() {

    companion object {
        fun newInstance() = SkillIqFragment()
    }

    //Lazily initialize LearningHoursViewModel
    private val viewModel: SkillIqViewModel by lazy {
        ViewModelProvider(this).get(SkillIqViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Databinding object
        val binding = SkillIqFragmentBinding.inflate(inflater, container, false)

        //Allow data binding to Obsere LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        //Give the binding access to LearningHoursViewModel
        binding.viewModel = viewModel
        return binding.root
    }



}
package com.example.leaderboardproject

import android.app.Fragment
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.leaderboardproject.databinding.LearningHoursFragmentBinding
import java.util.EnumSet.of
import java.util.List.of

class LearningHoursFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = LearningHoursFragment()
    }



    //Lazily initialize LearningHoursViewModel
    private val viewModel: LearningHoursViewModel by lazy {
        ViewModelProvider(this).get(LearningHoursViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Databinding object
        val binding = LearningHoursFragmentBinding.inflate(inflater, container, false)

        //Allow data binding to Obsere LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        //Give the binding access to LearningHoursViewModel
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
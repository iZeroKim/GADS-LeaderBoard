package com.example.leaderboardproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.leaderboardproject.databinding.LearningHoursFragmentBinding
import kotlinx.android.synthetic.main.learning_hours_fragment.*

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
        //val adapter = LearnerAdapter(viewModel.list, this)
        //rcView.adapter = adapter


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
package com.example.leaderboardproject

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import java.util.EnumSet.of
import java.util.List.of

class LearningHoursFragment : Fragment() {

    companion object {
        fun newInstance() = LearningHoursFragment()
    }

    private lateinit var viewModel: LearningHoursViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learning_hours_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider.of(LearningHoursViewModel::class.java).get()
        // TODO: Use the ViewModel
    }

}
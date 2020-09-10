package com.example.leaderboardproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboardproject.databinding.RowItemBinding
import com.example.leaderboardproject.databinding.RowItemIqBinding
import com.example.leaderboardproject.network.learninghours.LearnerDetails
import com.example.leaderboardproject.network.skilliq.LearnerIQDetails

class LearnerIQAdapter: ListAdapter<LearnerIQDetails, LearnerIQAdapter.LearnerViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnerViewHolder {
        return  LearnerViewHolder(RowItemIqBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: LearnerViewHolder, position: Int) {
        val learneriqDetails = getItem(position)
        holder.bind(learneriqDetails)
    }

    companion object DiffCallback:DiffUtil.ItemCallback<LearnerIQDetails>(){
        override fun areItemsTheSame(oldItem: LearnerIQDetails, newItem: LearnerIQDetails): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: LearnerIQDetails, newItem: LearnerIQDetails): Boolean {
            return oldItem == newItem
        }

    }
    class LearnerViewHolder(private var binding: RowItemIqBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(learneriqDetails: LearnerIQDetails){
            binding.learneriqDetails = learneriqDetails
            binding.executePendingBindings()
        }
    }
}

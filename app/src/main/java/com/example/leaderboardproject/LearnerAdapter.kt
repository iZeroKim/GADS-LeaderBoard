package com.example.leaderboardproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.leaderboardproject.databinding.LearningHoursFragmentBinding
import com.example.leaderboardproject.databinding.RowItemBinding
import com.example.leaderboardproject.network.learninghours.LearnerDetails

class LearnerAdapter: ListAdapter<LearnerDetails, LearnerAdapter.LearnerViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnerViewHolder {
        return  LearnerViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: LearnerViewHolder, position: Int) {
        val learnerDetails = getItem(position)
        holder.bind(learnerDetails)
    }

    companion object DiffCallback:DiffUtil.ItemCallback<LearnerDetails>(){
        override fun areItemsTheSame(oldItem: LearnerDetails, newItem: LearnerDetails): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: LearnerDetails, newItem: LearnerDetails): Boolean {
            return oldItem == newItem
        }

    }
    class LearnerViewHolder(private var binding: RowItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(learnerDetails: LearnerDetails){
            binding.learnerDetails = learnerDetails
            binding.executePendingBindings()
        }
    }
}

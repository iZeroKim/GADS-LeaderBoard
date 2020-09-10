package com.example.leaderboardproject

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.leaderboardproject.network.learninghours.LearnerDetails
import com.example.leaderboardproject.network.skilliq.LearnerIQDetails

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, url: String?){
    url.let {
        val imgUri = url?.toUri()?.buildUpon()?.scheme("https")?.build()
        Glide.with(imageView.context).load(imgUri).into(imageView)
    }
}

@BindingAdapter("LearnersList")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<LearnerDetails>?){
    val adapter =  recyclerView.adapter as LearnerAdapter
    adapter.submitList(data)
}

@BindingAdapter("LearnersIQList")
fun bindIqRecyclerView(iqrecyclerView: RecyclerView, datalist: List<LearnerIQDetails>?){
    val myAdapter =  iqrecyclerView.adapter as LearnerIQAdapter
    myAdapter.submitList(datalist)
}
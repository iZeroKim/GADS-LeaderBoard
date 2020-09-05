package com.example.leaderboardproject.network.learninghours

import com.squareup.moshi.Json

data class LearnerDetails(
    val name:String,
    val hours: Int,
    val country: String,
    @Json(name = "badgeUrl")val badgeUrl: String
)
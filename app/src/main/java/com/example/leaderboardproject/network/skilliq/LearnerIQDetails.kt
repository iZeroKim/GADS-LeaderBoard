package com.example.leaderboardproject.network.skilliq

import com.squareup.moshi.Json

data class LearnerIQDetails(
    val name:String,
    val score: Int,
    val country: String,
    @Json(name = "badgeUrl")val badgeUrl: String
)
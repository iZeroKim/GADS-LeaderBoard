package com.example.leaderboardproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        val handler = android.os.Handler();
        handler.postDelayed( Runnable() {
             run() {
                var intent = Intent(this, MainActivity::class.java);
                startActivity(intent)
            }
        }, 500);
    }
}
package com.example.leaderboardproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout

class SubmitActivity : AppCompatActivity() {
    lateinit var appBarLayout: AppBarLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        appBarLayout = findViewById<AppBarLayout>(R.id.appBarSubmit)
        var backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
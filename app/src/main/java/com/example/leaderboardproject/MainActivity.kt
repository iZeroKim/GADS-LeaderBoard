package com.example.leaderboardproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
import com.example.leaderboardproject.R.color.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    //Global Variables
    lateinit var tabLayout: TabLayout
    lateinit var appBarLayout: AppBarLayout
    lateinit var viewPager: ViewPager
    lateinit var submitBtn: Button

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing global variables
        tabLayout = findViewById(R.id.tabLayout)
        appBarLayout = findViewById(R.id.appBar)
        viewPager = findViewById(R.id.viewPager)
        submitBtn = findViewById(R.id.submitBtn)

        submitBtn.setOnClickListener {
            val intent = Intent(this, SubmitActivity::class.java)
            startActivity(intent)
        }

        //Get ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)
        //Add all fragments
        adapter.AddFragment(LearningHoursFragment(), "Learning Leaders")
        adapter.AddFragment(SkillIqFragment(), "Skill IQ Leaders")


        //Setup adapter
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }

//    override fun transformPage(page: View, position: Float) {
//        if (position <= -1){
//            page.setBackgroundResource(R.color.colorPrimary)
//        }
//        if (position <= 0){
//            page.setBackgroundResource(R.color.colorAccent)
//        }
//    }
}
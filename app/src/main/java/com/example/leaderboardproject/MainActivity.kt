package com.example.leaderboardproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    //Global Variables
    lateinit var tabLayout: TabLayout
    lateinit var appBarLayout: AppBarLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing global variables
        tabLayout = findViewById(R.id.tabLayout)
        appBarLayout = findViewById(R.id.appBar)
        viewPager = findViewById(R.id.viewPager)

        //Get ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)
        //Add all fragments
        adapter.AddFragment(SkillIqFragment(), "Skill IQ Leaders")
        adapter.AddFragment(LearningHoursFragment(), "Learning Leaders")

        //Setup adapter
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
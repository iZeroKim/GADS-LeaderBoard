package com.example.leaderboardproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    //Variable to hold all fragment instances
    val fragmentList = arrayListOf<Fragment>()
    //Variable to hold all fragment instances' titles
    val fragmentTitleList = arrayListOf<String>()

    override fun getCount(): Int {
        return  fragmentTitleList.size
    }

    override fun getItem(position: Int): Fragment {
        return  fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    //Function to add fragments into fragmentList and their title into fragmentTitleList
    fun AddFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}
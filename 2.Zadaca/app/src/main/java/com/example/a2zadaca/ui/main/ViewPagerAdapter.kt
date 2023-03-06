package com.example.a2zadaca.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a2zadaca.InputFragment
import com.example.a2zadaca.ListFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int) : Fragment {
        return when (position) {
            0 -> InputFragment()
            1 -> ListFragment()
            else -> InputFragment()
        }
    }
}
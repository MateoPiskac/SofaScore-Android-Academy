package com.example.a2zadaca

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.a2zadaca.databinding.ActivityMainBinding
import com.example.a2zadaca.ui.main.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val screenTitle = binding.title
        val viewPager = binding.viewPager
        val tabLayout = binding.tabs

        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Add"
                1 -> "Contacts"
                else -> "Invalid tab"
            }
        }.attach()

        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                screenTitle.text = when (position) {
                    0 -> "Add"
                    1 -> "Contacts"
                    else -> "Invalid tab"
                }
            }
        })
    }
}

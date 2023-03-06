package com.example.a2zadaca

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.a2zadaca.databinding.ActivityMainBinding
import com.example.a2zadaca.ui.main.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)

        val adapter = ViewPager2(supportFragmentManager)
        adapter.addFragment(InputFragment(), "Add")
        adapter.addFragment(ListFragment(), "Contacts")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }
}
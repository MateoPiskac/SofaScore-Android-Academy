package com.example.a2zadaca

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a2zadaca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val screenTitle = binding.title
        replaceFragment(InputFragment())

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.add_nav -> {
                    replaceFragment(InputFragment())
                    screenTitle.text = "Add"
                }
                R.id.cars_nav -> {
                    replaceFragment(ListFragment())
                    screenTitle.text = "Car List"
                }
                else -> {}
            }
            true
        }

    }
    private fun replaceFragment(inputFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame,inputFragment)
        fragmentTransaction.commit()

    }
    }


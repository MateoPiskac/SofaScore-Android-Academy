package com.example.a2zadaca

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a2zadaca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(InputFragment())
        binding.title.text = "Add"

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.add_nav -> {
                    binding.title.text = "Add"
                    replaceFragment(InputFragment())
                }
                R.id.cars_nav -> {
                    binding.title.text = "Car List"
                    replaceFragment(ListFragment())
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


package com.example.a1zadaca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonGreetingText: TextView = findViewById(R.id.buttonGreetingText)
        buttonGreetingText.visibility = GONE
        val greetingButton: Button = findViewById(R.id.button)
        greetingButton.setOnClickListener { updateGreeting(buttonGreetingText, greetingButton) }
    }

    private fun updateGreeting(buttonGreetingText: TextView, button: Button) {
        if (buttonGreetingText.visibility == GONE) {
            buttonGreetingText.visibility = VISIBLE
            button.text = "Hide Greeting"
        }
        else {
            buttonGreetingText.visibility = GONE
            button.text = "Show Greeting"
        }
    }
}
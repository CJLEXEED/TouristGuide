package com.example.touristguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the button and set click listener
        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            // Open JournalActivity when button is clicked
            val intent = Intent(this, JournalActivity::class.java)
            startActivity(intent)
        }
    }
}

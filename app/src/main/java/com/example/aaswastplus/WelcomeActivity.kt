package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    private lateinit var tvStart: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()
        tvStart = findViewById(R.id.btnStart)
        tvStart.setOnClickListener {
            startActivity(Intent(this, OnBoardingOneActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_right_exit)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
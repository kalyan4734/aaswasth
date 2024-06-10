package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OnBoardingOneActivity : AppCompatActivity() {
    private lateinit var btnContinueOne: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)
        supportActionBar?.hide()
        btnContinueOne = findViewById(R.id.btnContinueOne)
        val btnOneGoBack: TextView = findViewById(R.id.btnOneGoBack)
        btnOneGoBack.setOnClickListener {
            finish()
        }
        btnContinueOne.setOnClickListener {
            startActivity(Intent(this, OnBoardingTwoActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_right_exit)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
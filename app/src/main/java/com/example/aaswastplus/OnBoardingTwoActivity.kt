package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OnBoardingTwoActivity : AppCompatActivity() {
    private lateinit var btnContinueTwo: TextView
    private lateinit var btnOneGoBack: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)
        supportActionBar?.hide()
        btnContinueTwo = findViewById(R.id.btnContinueTwo)
        btnOneGoBack = findViewById(R.id.btnOneGoBack)
        btnOneGoBack.setOnClickListener {
            finish()
        }
        btnContinueTwo.setOnClickListener {
            startActivity(Intent(this, OnBoardingThreeActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_right_exit)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
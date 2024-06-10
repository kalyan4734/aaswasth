package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OnBoardingThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_three)
        supportActionBar?.hide()
        val btnContinue : TextView = findViewById(R.id.btnThreeContinue)
       val btnOneGoBack: TextView = findViewById(R.id.btnThreeGoBack)
        btnOneGoBack.setOnClickListener {
            finish()
        }
        btnContinue.setOnClickListener {
            startActivity(Intent(this, SlideEmergencyActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_right_exit)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
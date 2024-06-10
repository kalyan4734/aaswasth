package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.TextView

class SuccessActivity : AppCompatActivity() {
    private lateinit var tvGoBack: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        supportActionBar?.hide()
        tvGoBack = findViewById(R.id.btnGoBack)
        tvGoBack.setOnClickListener {
            val intent = Intent(this@SuccessActivity, HomeActivity::class.java)
            intent.putExtra("isFromBack", true)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_right_exit)
        }
    }
}
package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.TextView

class LoginSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_success)
        supportActionBar?.hide()
        val btnContinue: TextView = findViewById(R.id.btnContinue)
        btnContinue.setOnClickListener {
        startActivity(Intent(this, PersonalDetailsActivity::class.java))
        }
    }
}
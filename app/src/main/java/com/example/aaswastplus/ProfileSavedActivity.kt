package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileSavedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_saved)
        supportActionBar?.hide()
        val btnOk: TextView = findViewById(R.id.btnOk)
        btnOk.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

    }
}
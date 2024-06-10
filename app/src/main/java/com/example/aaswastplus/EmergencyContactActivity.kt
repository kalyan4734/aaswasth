package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EmergencyContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_contact)
        supportActionBar?.hide()
        val btnEmer: TextView = findViewById(R.id.btnSaveEmer)
        btnEmer.setOnClickListener {
            startActivity(Intent(this, ProfileSavedActivity::class.java))
        }
        val btnGoBack :  TextView = findViewById(R.id.btnThreeGoBack)
        btnGoBack.setOnClickListener {
            finish()
        }

    }
}
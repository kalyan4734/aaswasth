package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class OverLayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over_lay)
        supportActionBar?.hide()
        val btnOk: ImageView = findViewById(R.id.ivOverlay)
        btnOk.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
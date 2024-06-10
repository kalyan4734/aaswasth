package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MedicalActivity : AppCompatActivity() {
    private lateinit var tvYes: TextView
    private lateinit var tvNo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical)
        supportActionBar?.hide()
        val btnGoBack :  TextView = findViewById(R.id.btnThreeGoBack)
        btnGoBack.setOnClickListener {
            finish()
        }

        tvYes = findViewById(R.id.tvYes)
        tvNo = findViewById(R.id.tvNo)
        tvYes.setOnClickListener {
            tvYes.setBackgroundResource(R.drawable.selected_edit_text)
            tvNo.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvNo.setOnClickListener {
            tvYes.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvNo.setBackgroundResource(R.drawable.selected_edit_text)
        }
        val btnSave: TextView = findViewById(R.id.btnSave)
        btnSave.setOnClickListener {
            startActivity(Intent(this, AllergiesActivity::class.java))
        }
    }
}
package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class PersonalDetailsActivity : AppCompatActivity() {
    private lateinit var spinnerDay: Spinner
    private lateinit var spinnerMonth: Spinner
    private lateinit var spinnerYear: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_details)
        supportActionBar?.hide()
        val btnSave: TextView = findViewById(R.id.btnSave)
        btnSave.setOnClickListener {
            startActivity(Intent(this@PersonalDetailsActivity, BloodGroupActivity::class.java))
        }
        spinnerDay = findViewById(R.id.spinnerDay)
        spinnerMonth = findViewById(R.id.spinnerMonth)
        spinnerYear = findViewById(R.id.spinnerYear)
        val btnGoBack :  TextView = findViewById(R.id.btnThreeGoBack)
        btnGoBack.setOnClickListener {
            finish()
        }

        setupDaySpinner()
        setupMonthSpinner()
        setupYearSpinner()
    }

    private fun setupDaySpinner() {
        val days = mutableListOf("Day")
        days.addAll((1..31).map { it.toString() })
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDay.adapter = adapter
    }

    private fun setupMonthSpinner() {
        val months = listOf(
            "Month","January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMonth.adapter = adapter
    }

    private fun setupYearSpinner() {
        val years = mutableListOf("Year")
        years.addAll( (1900..2023).map { it.toString() })
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerYear.adapter = adapter
    }
}
package com.example.aaswastplus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AppCompatActivity

class LanguageSelectionActivity : AppCompatActivity() {
    @SuppressLint("AppCompatMethod")
    private lateinit var tvContinue: TextView
    private lateinit var btnEnglish: TextView
    private lateinit var btnMarathi: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_selection)
        supportActionBar?.hide()
        tvContinue = findViewById(R.id.btnContinue)
        btnEnglish = findViewById(R.id.btnEnglish)
        btnMarathi = findViewById(R.id.btnMarathi)
        btnEnglish.setOnClickListener {
            btnEnglish.setBackgroundResource(R.drawable.selected_edit_text)
            btnMarathi.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        btnMarathi.setOnClickListener {
            btnMarathi.setBackgroundResource(R.drawable.selected_edit_text)
            btnEnglish.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvContinue.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_right_exit)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
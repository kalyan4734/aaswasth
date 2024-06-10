package com.example.aaswastplus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE)
                val myBooleanValue = sharedPref.getBoolean("LoginSuccess", false)
                intent = if (myBooleanValue)
                    Intent(this, HomeActivity::class.java)
                else
                    Intent(this, LanguageSelectionActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000
        )
    }
}
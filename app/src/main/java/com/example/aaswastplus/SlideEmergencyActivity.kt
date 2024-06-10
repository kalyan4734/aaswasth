package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class SlideEmergencyActivity : AppCompatActivity() {
    private lateinit var textSlide: TextView
    private lateinit var btnGoBack: TextView
    private lateinit var btnContinue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_emergency)
        supportActionBar?.hide()
        textSlide = findViewById(R.id.tvSlideEmergency)
        btnContinue = findViewById(R.id.btnContinueEmergency)
        btnContinue.setOnClickListener {
            startActivity(Intent(this, SlideEmergencyPracticeActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_right_exit)
        }
        btnGoBack = findViewById(R.id.btnEmergencyGoBack)
        btnGoBack.setOnClickListener {
            finish()
        }
        val buttonEmergency: ImageButton = findViewById(R.id.btnEmergency)

        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slider_in_right_slider)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeoutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        buttonEmergency.visibility = View.VISIBLE
        buttonEmergency.startAnimation(slideInAnimation)
        textSlide.visibility = View.VISIBLE
       textSlide.startAnimation(fadeoutAnimation)
       Handler(Looper.getMainLooper()).postDelayed({
           textSlide.visibility = View.VISIBLE
           textSlide.startAnimation(fadeInAnimation)
           btnContinue.visibility = View.VISIBLE
           btnGoBack.visibility = View.VISIBLE
       },3000)
    }
}
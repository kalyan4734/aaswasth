package com.example.aaswastplus

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity

class SlideEmergencyPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_emergency_practice)
        supportActionBar?.hide()
        val customSeekBar: SeekBar = findViewById(R.id.seekBar)
        customSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if(progress == 100){
                   startActivity(Intent(this@SlideEmergencyPracticeActivity, WellDoneActivity::class.java))
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Handle start of touch
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Handle stop of touch
            }
        })
    }
}
package com.example.aaswastplus

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class HomeActivity : AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var tvDocName: TextView
    private lateinit var tvTime: TextView
    private lateinit var tvDocImg: TextView
    private var isFromBack :Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        isFromBack = intent.getBooleanExtra("isFromBack", false)
        val toolbar: Toolbar? = findViewById(R.id.toolBar)
        if (toolbar == null) {
            Log.e("Home", "Toolbar is null")
        } else {
            setSupportActionBar(toolbar)
        }
        tvName = findViewById(R.id.tvPerson)
        tvDocName = findViewById(R.id.tvDocName)
        tvTime = findViewById(R.id.tvDocTime)
        tvDocImg = findViewById(R.id.tvDocImg)
        val sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val name = sharedPref.getString("name", "")
        tvName.text = "Hello $name"
        if(isFromBack){
            tvDocName.text = getString(R.string.amb_arri)
            tvTime.text = getString(R.string.amb_arrives_in)
            tvDocImg.setBackgroundResource(R.drawable.amubu)
        }

        val customSeekBar: SeekBar = findViewById(R.id.seekBar)
        customSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if(progress == 100){
                    startActivity(Intent(this@HomeActivity, CallingActivity::class.java))
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
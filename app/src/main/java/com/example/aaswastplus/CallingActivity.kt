package com.example.aaswastplus

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class CallingActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var tvTimer: TextView
    private lateinit var tvSpeaker: TextView
    private lateinit var tvCancelCall: TextView
    private val handler = Handler(Looper.getMainLooper())
    private val images = listOf(
        R.drawable.call_four,
        R.drawable.call_three,
        R.drawable.calling_two,
        R.drawable.calling_one,
        R.drawable.connecting1,
        R.drawable.connecting2,
        R.drawable.connecting3,
        R.drawable.connecting4,
        R.drawable.connecting5
    )


    private var currentIndex = 0
    private lateinit var job: Job
    private lateinit var job1: Job
    private val phoneNumber = "tel:+919848182726"
    private var timerCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling)
        supportActionBar?.hide()
        imageView = findViewById(R.id.ivCalling)
        tvTimer = findViewById(R.id.tvTwoHeader)
        tvSpeaker = findViewById(R.id.tvSpeaker)
        tvTimer = findViewById(R.id.tvTwoHeader)
        tvCancelCall = findViewById(R.id.btnCancelCall)
        startImageCycle()
    }

    private fun startImageCycle() {
        job = CoroutineScope(Dispatchers.Main).launch {
            while (currentIndex < images.size) {
                imageView.setImageResource(images[currentIndex])
                currentIndex++
                if (currentIndex > 4) tvSpeaker.visibility = View.VISIBLE
                delay(1000) // Change every second
            }
            setTimer()
        }

    }

    private fun setTimer() {
        job1 = CoroutineScope(Dispatchers.Main).launch {
            tvCancelCall.background = getDrawable(R.drawable.end_call)
            while (timerCount < 60) {
                tvTimer.text =
                    if (timerCount < 9) "00:0$timerCount" else if (timerCount in 60..68) "01:0$timerCount" else "00:$timerCount"
                timerCount++
                delay(1000)
                tvCancelCall.setOnClickListener {
                    startActivity(Intent(this@CallingActivity, SuccessActivity::class.java))
                }
            }
        }
    }


    private fun makePhoneCall(phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse(phoneNumber)
        startActivity(callIntent)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            makePhoneCall(phoneNumber)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        // job1.cancel()
    }
}
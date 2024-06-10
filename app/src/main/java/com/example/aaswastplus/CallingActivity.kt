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
import android.Manifest
import android.os.Build
import android.telecom.TelecomManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.*

class CallingActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var tvTimer: TextView
    private lateinit var tvSpeaker: TextView
    private lateinit var tvCancelCall: TextView
    private val REQUEST_CODE_ANSWER_PHONE_CALLS = 11
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

    @RequiresApi(Build.VERSION_CODES.P)
    private fun startImageCycle() {
        job = CoroutineScope(Dispatchers.Main).launch {
            while (currentIndex < images.size) {
                imageView.setImageResource(images[currentIndex])
                currentIndex++
                if (currentIndex > 4){
                    tvSpeaker.visibility = View.VISIBLE
                }
                delay(1000) // Change every second
            }
            setTimer()
        }

    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun setTimer() {
        job1 = CoroutineScope(Dispatchers.Main).launch {
            tvCancelCall.background = getDrawable(R.drawable.end_call)
            while (timerCount < 60) {
                tvTimer.text =
                    if (timerCount < 9) "00:0$timerCount" else if (timerCount in 60..68) "01:0$timerCount" else "00:$timerCount"
                timerCount++
                delay(1000)
                if(timerCount == 1)  { makePhoneCall(phoneNumber)
                    tvCancelCall.setOnClickListener {
                        dismissCall()
                        startActivity(Intent(this@CallingActivity, SuccessActivity::class.java))
                    }}

            }

            }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun dismissCall() {
        val telecomManager = getSystemService(TELECOM_SERVICE) as TelecomManager
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ANSWER_PHONE_CALLS) == PackageManager.PERMISSION_GRANTED) {
            telecomManager.endCall()
        } else {
            // Permission not granted
        }
    }

    private fun makePhoneCall(phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse(phoneNumber)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
        } else {
            startActivity(callIntent)
        }

    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            makePhoneCall(phoneNumber)
        }
        if (requestCode == REQUEST_CODE_ANSWER_PHONE_CALLS) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
              dismissCall()
            } else {
                // Permission denied
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        // job1.cancel()
    }
}
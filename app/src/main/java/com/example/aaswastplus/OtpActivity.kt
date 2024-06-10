package com.example.aaswastplus

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class OtpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var etOtp1: EditText
    private lateinit var etOtp2: EditText
    private lateinit var etOtp3: EditText
    private lateinit var etOtp4: EditText
    private lateinit var etOtp5: EditText
    private lateinit var etOtp6: EditText
    private lateinit var btnVerifyOtp: TextView
    private lateinit var  btnGoBack: TextView
    private lateinit var verificationId: String
    private lateinit var mobileNumber: String
    private lateinit var ccProgress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()
        verificationId = intent.getStringExtra("verificationId") ?: ""
        mobileNumber = intent.getStringExtra("mobileNumber") ?: ""
        val mobileText: TextView = findViewById(R.id.tvOtpText)
        ccProgress = findViewById(R.id.ccProgress)
        btnVerifyOtp = findViewById(R.id.btnLogin)
        btnGoBack = findViewById(R.id.btnThreeGoBack)
        mobileText.text = "Enter OTP sent to $mobileNumber"
        etOtp1 = findViewById(R.id.etOtp1)
        etOtp2 = findViewById(R.id.etOtp2)
        etOtp3 = findViewById(R.id.etOtp3)
        etOtp4 = findViewById(R.id.etOtp4)
        etOtp5 = findViewById(R.id.etOtp5)
        etOtp6 = findViewById(R.id.etOtp6)



            etOtp1.doOnTextChanged { text, start, before, count ->
                if(text?.length == 1) etOtp2.requestFocus()
            }

        etOtp2.doOnTextChanged { text, start, before, count ->
            if(text?.length == 1) etOtp3.requestFocus()
        }
        etOtp3.doOnTextChanged { text, start, before, count ->
            if(text?.length == 1) etOtp4.requestFocus()
        }
        etOtp4.doOnTextChanged { text, start, before, count ->
            if(text?.length == 1) etOtp5.requestFocus()
        }
        etOtp5.doOnTextChanged { text, start, before, count ->
            if(text?.length == 1) etOtp6.requestFocus()
        }
        etOtp6.doOnTextChanged { text, start, before, count ->
            if(text?.length == 1) hideKeyboard()
        }

        btnGoBack.setOnClickListener {
            finish()
        }
        btnVerifyOtp.setOnClickListener {
            ccProgress.visibility = View.VISIBLE
         //   startActivity(Intent(this@OtpActivity, LoginSuccessActivity::class.java))
        verifyCode(etOtp1.text.trim().toString()+etOtp2.text.trim().toString()+etOtp3.text.trim().toString()+etOtp4.text.trim().toString()+etOtp5.text.trim().toString()+etOtp6.text.trim().toString())
        }

    }

    private fun verifyCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithCredential(credential)
    }

    private fun signInWithCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    ccProgress.visibility = View.GONE
                    Toast.makeText(this, "Verification Successful", Toast.LENGTH_SHORT).show()
                    val sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putBoolean("LoginSuccess", true)  // or false
                    editor.apply()
                    // Proceed to the next activity or home screen
                    startActivity(Intent(this@OtpActivity, LoginSuccessActivity::class.java))
                } else {
                    ccProgress.visibility = View.GONE
                    Toast.makeText(this, "Verification Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun hideKeyboard() {
        val view: View? = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }
}
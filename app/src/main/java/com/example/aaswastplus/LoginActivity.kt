package com.example.aaswastplus

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var etPhoneNumber: EditText
    private lateinit var etName: EditText
    private lateinit var etOtp: EditText
    private lateinit var btnSendOtp: TextView
    private lateinit var btnGoBack: TextView
    private lateinit var invalidMobile: TextView
    private lateinit var verificationId: String
    private lateinit var ccProgress: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()
        etPhoneNumber = findViewById(R.id.etMobile)
        etName = findViewById(R.id.etName)
        invalidMobile =findViewById(R.id.tvInavlidMobileNumber)
        btnSendOtp = findViewById(R.id.btnLogin)
        btnGoBack = findViewById(R.id.btnThreeGoBack)
        ccProgress = findViewById(R.id.ccProgress)
        etPhoneNumber.doOnTextChanged { text, start, before, count ->
            if(text?.length == 10) hideKeyboard()
        }
        etPhoneNumber.doOnTextChanged { text, start, before, count ->
            if(etPhoneNumber.text.isNotEmpty()) etPhoneNumber.background = getDrawable(R.drawable.selected_edit_text)
            invalidMobile.visibility = View.GONE
        }
        btnGoBack.setOnClickListener {
            finish()
        }
        btnSendOtp.setOnClickListener {
            val phoneNumber = etPhoneNumber.text.toString().trim()
            if (phoneNumber.isEmpty() || phoneNumber.length < 10) {
                invalidMobile.visibility = View.VISIBLE
                etPhoneNumber.background = getDrawable(R.drawable.error_edit_text)

            } else {
                val sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("name", etName.text.toString())  // or false
                editor.apply()
                 sendVerificationCode("+91$phoneNumber")
            }

        }


    }


    private fun sendVerificationCode(phoneNumber: String) {
        Log.d("mobile", phoneNumber)
        ccProgress.visibility = View.VISIBLE
       val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.
                Log.d(TAG, "onVerificationCompleted:$credential")


            //    signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e)

                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
                    // reCAPTCHA verification attempted with null Activity
                }

                // Show a message and update the UI
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken,
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:$verificationId")

                ccProgress.visibility = View.GONE
                val intent = Intent(this@LoginActivity, OtpActivity::class.java)
                intent.putExtra("verificationId", verificationId)
                intent.putExtra("mobileNumber", phoneNumber)
                startActivity(intent)
                // Save verification ID and resending token so we can use them later
//                storedVerificationId = verificationId
//                resendToken = token
            }
        }
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun hideKeyboard() {
        val view: View? = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }
}
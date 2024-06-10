package com.example.aaswastplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BloodGroupActivity : AppCompatActivity() {
    private lateinit var tvAp:TextView
    private lateinit var tvAn:TextView
    private lateinit var tvBp:TextView
    private lateinit var tvBn:TextView
    private lateinit var tvABp:TextView
    private lateinit var tvABn:TextView
    private lateinit var tvOp:TextView
    private lateinit var tvOn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_group)
        supportActionBar?.hide()
        tvAp = findViewById(R.id.tvAp)
        tvAn = findViewById(R.id.tvAn)
        tvBp = findViewById(R.id.tvBp)
        tvBn = findViewById(R.id.tvBn)
        tvABp = findViewById(R.id.tvAbp)
        tvABn = findViewById(R.id.tvAbn)
        tvOp = findViewById(R.id.tvOp)
        tvOn = findViewById(R.id.tvOn)
        val btnSave: TextView = findViewById(R.id.btnSave)

        tvAp.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.selected_edit_text)
            tvAn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOn.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvAn.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvAn.setBackgroundResource(R.drawable.selected_edit_text)
            tvBp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOn.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvBp.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvAn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBp.setBackgroundResource(R.drawable.selected_edit_text)
            tvBn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOn.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvBn.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvAn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBn.setBackgroundResource(R.drawable.selected_edit_text)
            tvABp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOn.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvABp.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvAn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABp.setBackgroundResource(R.drawable.selected_edit_text)
            tvABn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOn.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvABn.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvAn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABn.setBackgroundResource(R.drawable.selected_edit_text)
            tvOp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOn.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvOp.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvAn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOp.setBackgroundResource(R.drawable.selected_edit_text)
            tvOn.setBackgroundResource(R.drawable.edit_text_back_ground)
        }
        tvOn.setOnClickListener {
            tvAp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvAn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvBn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvABn.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOp.setBackgroundResource(R.drawable.edit_text_back_ground)
            tvOn.setBackgroundResource(R.drawable.selected_edit_text)
        }
        val btnGoBack :  TextView = findViewById(R.id.btnThreeGoBack)
        btnGoBack.setOnClickListener {
            finish()
        }

        btnSave.setOnClickListener {
            startActivity(Intent(this, MedicalActivity::class.java))
        }
    }
}
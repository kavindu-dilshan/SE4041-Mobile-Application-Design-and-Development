package com.example.labsheet02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btnStart)
        btnStart.setOnClickListener {
            startActivity(Intent(this, BillCalculatorActivity::class.java))
        }
    }
}
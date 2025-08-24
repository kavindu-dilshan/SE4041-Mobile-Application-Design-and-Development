package com.example.labsheet02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BillCalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_calculator)

        val unitCost = findViewById<EditText>(R.id.txtUnits)
        val lblBill = findViewById<TextView>(R.id.lblBill)

        findViewById<Button>(R.id.btnCalculate).setOnClickListener {
            val units = unitCost.text.toString().toIntOrNull() ?: 0
            val subtotal = 150.0 + (units * 29.0)
            val total = subtotal * 1.15
            lblBill.text = "Electricity Bill: LKR %.2f".format(total)
        }
    }
}
package com.example.labsheet04


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// package com.example.labsheet04
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.input)

        // big "Add" button (kept)
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val text = input.text.toString().trim()
            if (text.isNotEmpty()) {
                TodoStore.items.add(TodoStore.Todo(text))
                input.text.clear()
            }
        }

        // bottom bar buttons
        findViewById<Button>(R.id.btnAddTab).setOnClickListener {
            // we’re already on Add screen; no-op or scroll to input
        }
        findViewById<Button>(R.id.btnView).setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
    }
}
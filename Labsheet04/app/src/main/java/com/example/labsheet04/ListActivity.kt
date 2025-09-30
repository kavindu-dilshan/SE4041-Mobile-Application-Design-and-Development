package com.example.labsheet04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// package com.example.labsheet04
class ListActivity : AppCompatActivity() {
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        adapter = TodoAdapter(
            onEdit = { item -> showEditDialog(item) },
            onDelete = { item -> TodoStore.items.remove(item).also { adapter.notifyDataSetChanged() } }
        )

        findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = this@ListActivity.adapter
        }

        // bottom bar buttons
        findViewById<Button>(R.id.btnAddTab).setOnClickListener {
            // go to Add screen
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnView).setOnClickListener {
            // we’re already on View screen; no-op
        }
    }

    private fun showEditDialog(item: TodoStore.Todo) {
        val input = EditText(this).apply { setText(item.title) }
        AlertDialog.Builder(this)
            .setTitle("Edit Todo")
            .setView(input)
            .setPositiveButton("Save") { _, _ ->
                val t = input.text.toString().trim()
                if (t.isNotEmpty()) item.title = t
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
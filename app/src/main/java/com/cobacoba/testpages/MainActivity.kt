package com.cobacoba.testpages

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)
        val rvTasks = findViewById<RecyclerView>(R.id.rvTasks)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)

        taskAdapter = TaskAdapter(emptyList())
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter

        fabAdd.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        // Ambil ulang data dari Database.kt
        val tasks = dbHelper.getAllTasks()
        // Update adapter dengan data baru
        taskAdapter.updateData(tasks)
    }
}
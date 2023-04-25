package com.github.sceneren.module

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity() {
    private lateinit var btn: Button

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        btn = findViewById(R.id.btn)
        btn.setOnClickListener {
            count++
            btn.text = "点击(${count})"
        }
    }
}
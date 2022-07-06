package com.github.sceneren.debounced

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.sceneren.debounced.databinding.ActivityMainBinding
import com.github.sceneren.debunced.DebouncedPredictor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvText.setOnClickListener {
            if (DebouncedPredictor.shouldDoClick(it)) {
                Log.e("ONCLICK", "===>ONCLICK")
            }
        }
    }
}
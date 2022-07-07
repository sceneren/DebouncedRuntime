package com.github.sceneren.debounced

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.sceneren.debounced.databinding.ActivityMainBinding
import com.github.sceneren.debunced.DebouncedPredictor
import com.github.sceneren.debunced.UncheckViewOnClick

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvText.text = "点击次数：${count}"
        binding.btnKotlinLambda.setOnClickListener {
            count += 1
            binding.tvText.text = "点击次数：${count}"
        }
        binding.btnNoCheck.setOnClickListener(object : View.OnClickListener {
            @UncheckViewOnClick
            override fun onClick(p0: View?) {
                count += 1
                binding.tvText.text = "点击次数：${count}"
            }

        })
    }
}
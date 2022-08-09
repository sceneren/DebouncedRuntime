package com.github.sceneren.debounced

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.sceneren.debounced.databinding.ActivityMainBinding
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

        binding.btnKotlinNoLambda.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                count += 1
                binding.tvText.text = "点击次数：${count}"
            }

        })

        binding.btnNoCheck.setOnClickListener(object : View.OnClickListener {
            @UncheckViewOnClick
            override fun onClick(p0: View?) {
                count += 1
                binding.tvText.text = "点击次数：${count}"
            }

        })


        val list = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MainAdapter().apply {
            setOnItemClickListener { adapter, view, position ->
                count += 1
                binding.tvText.text = "点击次数：${count}"
            }
            addData(list)
        }

    }
}
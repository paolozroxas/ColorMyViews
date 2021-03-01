package com.example.colormyviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBoxListeners()
    }

    private fun setBoxListeners() {
        val views: List<View> = listOf(
            binding.tvBox1,
            binding.tvBox2,
            binding.tvBox3,
            binding.tvBox4,
            binding.tvBox5,
        )
        views.forEach { view -> view.setOnClickListener { makeColored(it) } }
    }

    private fun makeColored(view: View) {
        val colors = listOf(
            android.R.color.holo_blue_bright,
            android.R.color.holo_red_light,
            android.R.color.holo_green_light,
            android.R.color.holo_purple,
            android.R.color.holo_orange_light,
        )
        val randomColorIdx = Random.nextInt(0, 4)
        view.setBackgroundResource(colors[randomColorIdx])
    }
}
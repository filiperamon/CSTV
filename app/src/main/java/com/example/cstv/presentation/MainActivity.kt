package com.example.cstv.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cstv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
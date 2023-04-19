package com.example.cstv.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.cstv.databinding.ActivitySplashBinding
import com.example.cstv.presentation.match.MatchActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding: ActivitySplashBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(4000)
            routerToMatchActivity()
        }

    }

    private suspend fun routerToMatchActivity() {
        val intent = Intent(this, MatchActivity::class.java)
        startActivity(intent)
    }
}
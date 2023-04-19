package com.example.cstv.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cstv.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val viewModel: MatchViewModel by viewModels()

    private val matchAdapter = MatchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMatchAdapter()

        lifecycleScope.launch {
            viewModel.matchPagingData("").collect { paginData ->
                matchAdapter.submitData(paginData)
            }
        }
    }

    private fun initMatchAdapter() {
        binding.recyclerMatch.run {
            setHasFixedSize(true)
            adapter = matchAdapter
        }
    }
}
package com.example.cstv.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.cstv.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
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
        observeInitialLoadingState()

        lifecycleScope.launch {
            viewModel.matchPagingData("").collect { pagingData ->
                matchAdapter.submitData(pagingData)
            }
        }
    }

    private fun initMatchAdapter() {
        binding.recyclerMatch.run {
            setHasFixedSize(true)
            adapter = matchAdapter
        }
    }

    private fun observeInitialLoadingState() {
        lifecycleScope.launch {
            matchAdapter.loadStateFlow.collectLatest { loading ->
                when (loading.refresh) {
                    is LoadState.Loading -> {
                        binding.recyclerMatch.visibility = View.GONE
                        binding.imageLoading.visibility = View.VISIBLE
                    }
                    is LoadState.NotLoading -> {
                        binding.recyclerMatch.visibility = View.VISIBLE
                        binding.imageLoading.visibility = View.GONE
                    }
                }
            }
        }
    }
}
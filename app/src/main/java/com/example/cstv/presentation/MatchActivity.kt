package com.example.cstv.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core.domain.model.Game
import com.example.core.domain.model.League
import com.example.core.domain.model.Match
import com.example.core.domain.model.Opponent
import com.example.cstv.databinding.ActivityMainBinding

class MatchActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val matchAdapter = MatchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMatchAdapter()

        matchAdapter.submitList(
            listOf(
                Match(
                        League("Premier League", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"),
                        listOf(
                            Opponent(1L, "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg", "Arsenal"),
                            Opponent(1L, "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg", "Liverpol")
                        ),
                        Game("", false, false, 1L, "")
                    ),
                )
            )
    }

    private fun initMatchAdapter() {
        binding.recyclerMatch.run {
            setHasFixedSize(true)
            adapter = matchAdapter
        }
    }
}
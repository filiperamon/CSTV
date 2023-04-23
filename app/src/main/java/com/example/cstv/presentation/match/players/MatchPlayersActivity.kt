package com.example.cstv.presentation.match.players

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.core.domain.model.Match
import com.example.cstv.databinding.ActivityMatchPlayersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchPlayersActivity : AppCompatActivity() {

    private var _binding: ActivityMatchPlayersBinding? = null
    private val binding: ActivityMatchPlayersBinding get() = _binding!!

    private val viewModel: MatchPlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMatchPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val match = getMatchExtras()
    }

    private fun getMatchExtras(): Match {
        return getExtras().getSerializable(MATCH_EXTRA) as Match
    }

    private fun getExtras(): Bundle {
        return intent.extras!!
    }

    companion object {
        const val MATCH_EXTRA = "match_extra"
    }
}
package com.example.cstv.presentation.match.players

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cstv.databinding.ActivityMatchPlayersBinding

class MatchPlayersActivity : AppCompatActivity() {

    private var _binding: ActivityMatchPlayersBinding? = null
    private val binding: ActivityMatchPlayersBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMatchPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val matchId = getMatchExtras()
    }

    private fun getMatchExtras(): Long {
        return getExtras().getLong(MATCH_EXTRA)
    }

    private fun getExtras(): Bundle {
        return intent.extras!!
    }

    companion object {
        const val MATCH_EXTRA = "match_extra"
    }
}
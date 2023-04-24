package com.example.cstv.presentation.match.players

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.core.domain.model.Match
import com.example.cstv.databinding.ActivityMatchTeamBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchTeamActivity : AppCompatActivity() {

    private var _binding: ActivityMatchTeamBinding? = null
    private val binding: ActivityMatchTeamBinding get() = _binding!!

    private val viewModel: MatchTeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMatchTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val match = getMatchExtras()

        configButtonListeners()

        loadTeamApi()
    }

    private fun loadTeamApi() {

        lifecycleScope.launch {
            viewModel.teamPagingData("").collect { pagingData ->
                //matchAdapter.submitData(pagingData)
                Log.d("TEAM", pagingData.toString())
            }
        }
    }

    private fun configButtonListeners() {
        binding.imageBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
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
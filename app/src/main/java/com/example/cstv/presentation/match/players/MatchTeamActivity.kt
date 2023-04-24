package com.example.cstv.presentation.match.players

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.core.domain.model.Match
import com.example.cstv.R
import com.example.cstv.databinding.ActivityMatchTeamBinding
import com.example.cstv.utils.EMPTY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchTeamActivity : AppCompatActivity() {

    private var _binding: ActivityMatchTeamBinding? = null
    private val binding: ActivityMatchTeamBinding get() = _binding!!

    private val viewModel: MatchTeamViewModel by viewModels()

    private val teamAdapter = TeamAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMatchTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getTeamExtras()

        initTeamAdapter()
        configButtonListeners()

        //loadTeamApi()
    }

    private fun initTeamAdapter() {
        binding.recyclerPlayers.run {
            setHasFixedSize(true)
            adapter = teamAdapter
        }
    }

    private fun loadTeamApi() {

        lifecycleScope.launch {
            viewModel.teamPagingData("").collect { pagingData ->
                teamAdapter.submitData(pagingData)
            }
        }
    }

    private fun configButtonListeners() {
        binding.imageBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getTeamExtras() {
        binding.textviewPlayerHomeName.text = getExtras()?.getString(TEAM_A_NAME) ?: getString(R.string.default_team_one)
        binding.textviewPlayerGuestName.text = getExtras()?.getString(TEAM_B_NAME) ?: getString(R.string.default_team_two)
        binding.titleSerieLeague.text = getExtras()?.getString(LEAGUE_NAME) ?: String.EMPTY

        val imageHome = getExtras()?.getString(TEAM_A_IMAGE) ?: String.EMPTY
        val imageGuest = getExtras()?.getString(TEAM_B_IMAGE) ?: String.EMPTY

        binding.run {
            Glide.with(this.imagePlayerHome)
                .load(imageHome)
                .fallback(R.drawable.background_img_error)
                .into(this.imagePlayerHome)

            Glide.with(this.imagePlayerGuest)
                .load(imageGuest)
                .fallback(R.drawable.background_img_error)
                .into(this.imagePlayerGuest)
        }
    }

    private fun getExtras(): Bundle? {
        return intent.extras
    }

    companion object {
        const val TEAM_A_NAME  = "team_a_name"
        const val TEAM_B_NAME  = "team_b_name"
        const val TEAM_A_IMAGE = "team_a_image"
        const val TEAM_B_IMAGE = "team_b_image"
        const val LEAGUE_NAME  = "league_name"
    }
}
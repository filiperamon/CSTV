package com.example.cstv.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import com.example.core.domain.model.Match
import com.example.cstv.R
import com.example.cstv.databinding.ItemMatchBinding

class MatchViewHolder(
    itemMatchBinding: ItemMatchBinding
): RecyclerView.ViewHolder(itemMatchBinding.root) {

    private val textTeamHomeName    = itemMatchBinding.textviewTeamHomeName
    private val textTeamGuestName   = itemMatchBinding.textviewTeamGuestName
    private val imgTeamHome         = itemMatchBinding.imageOpponentHome
    private val imgTeamGuest        = itemMatchBinding.imageOpponentGuest
    private val imgLeague           = itemMatchBinding.imageLeague
    private val leagueName          = itemMatchBinding.textLeagueSerie

    fun bind(match: Match) {
        leagueName.text = match.league.name

        match.opponent?.let { opponents ->
            if(opponents.isNotEmpty()){

                opponents[0].let { homeTeam ->
                    textTeamHomeName.text = homeTeam.name

                    Glide.with(itemView)
                        .load(homeTeam.imageUrl)
                        .fallback(R.drawable.background_img_error)
                        .into(imgTeamHome)
                }

                opponents[1].let {guestTeam ->
                    textTeamGuestName.text = guestTeam.name

                    Glide.with(itemView)
                        .load(guestTeam.imageUrl)
                        .fallback(R.drawable.background_img_error)
                        .into(imgTeamGuest)
                }
            }
        }


        imgLeague.load(match.league.imgUrl) {
            crossfade(true)
            placeholder(R.drawable.background_img_error)
            transformations(CircleCropTransformation())
        }

    }

    companion object {
        fun create(parent: ViewGroup): MatchViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemMatchBinding = ItemMatchBinding.inflate(inflater, parent, false)
            return MatchViewHolder(itemMatchBinding)
        }
    }
}
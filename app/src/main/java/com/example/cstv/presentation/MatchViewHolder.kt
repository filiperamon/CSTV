package com.example.cstv.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.domain.model.EStatus
import com.example.core.domain.model.Match
import com.example.core.domain.model.Opponent
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
    private val matchDate           = itemMatchBinding.textviewDate

    fun bind(match: Match) {

        leagueName.text = "${match.league.name} + ${match.serie.name}"


        if(match.status == EStatus.RUNNING.value) {
            matchDate.setBackgroundResource(R.drawable.bg_date_online)
            matchDate.text = "AGORA"
        } else {
            matchDate.setBackgroundResource(R.drawable.bg_date_time)
            matchDate.text = match.date
        }

        if(match.opponent.isNotEmpty()) {

            textTeamHomeName.text = match.opponent[0].name

            Glide.with(itemView)
                .load(match.opponent[0].imageUrl)
                .fallback(R.drawable.background_img_error)
                .into(imgTeamHome)
        } else {
            imgTeamHome.setImageResource(R.drawable.background_img_error)
        }

        if(match.opponent.size > 1) {

            textTeamGuestName.text = match.opponent[1].name

            Glide.with(itemView)
                .load(match.opponent[1].imageUrl)
                .fallback(R.drawable.background_img_error)
                .into(imgTeamGuest)
        } else {
            imgTeamGuest.setImageResource(R.drawable.background_img_error)
        }

        Glide.with(itemView)
            .load(match.league.imgUrl)
            .fallback(R.drawable.background_img_error)
            .into(imgLeague)
    }

    companion object {
        fun create(parent: ViewGroup): MatchViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemMatchBinding = ItemMatchBinding.inflate(inflater, parent, false)
            return MatchViewHolder(itemMatchBinding)
        }
    }
}
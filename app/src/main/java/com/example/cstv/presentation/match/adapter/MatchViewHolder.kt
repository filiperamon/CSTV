package com.example.cstv.presentation.match.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.domain.model.EStatus
import com.example.core.domain.model.Match
import com.example.cstv.utils.DateUtils
import com.example.cstv.R
import com.example.cstv.databinding.ItemMatchBinding
import com.example.cstv.presentation.match.players.MatchTeamActivity
import com.example.cstv.utils.EMPTY

class MatchViewHolder(
    itemMatchBinding: ItemMatchBinding,
    private val context: Context
): RecyclerView.ViewHolder(itemMatchBinding.root) {

    private val textTeamHomeName    = itemMatchBinding.textviewTeamHomeName
    private val textTeamGuestName   = itemMatchBinding.textviewTeamGuestName
    private val imgTeamHome         = itemMatchBinding.imageOpponentHome
    private val imgTeamGuest        = itemMatchBinding.imageOpponentGuest
    private val imgLeague           = itemMatchBinding.imageLeague
    private val leagueName          = itemMatchBinding.textLeagueSerie
    private val matchDate           = itemMatchBinding.textviewDate
    private val cardMatch           = itemMatchBinding.cardCharacter

    private var imageTeamA: String = String.EMPTY
    private var imageTeamB: String = String.EMPTY

    fun bind(match: Match) {

        leagueName.text = "${match.league.name} + ${match.serie.name}"

        if(match.status == EStatus.RUNNING.value) {
            matchDate.setBackgroundResource(R.drawable.bg_date_online)
            matchDate.text = context.getString(R.string.time_now)
        } else {
            matchDate.setBackgroundResource(R.drawable.bg_date_time)
            matchDate.text = DateUtils.formatDateInFull(context, match.date)
        }

        if(match.opponent.isNotEmpty()) {

            textTeamHomeName.text = match.opponent[0].name
            imageTeamA = match.opponent[0].imageUrl ?: String.EMPTY

            Glide.with(itemView)
                .load(match.opponent[0].imageUrl)
                .fallback(R.drawable.background_img_error)
                .into(imgTeamHome)
        } else {
            imgTeamHome.setImageResource(R.drawable.background_img_error)
        }

        if(match.opponent.size > 1) {

            textTeamGuestName.text = match.opponent[1].name
            imageTeamB = match.opponent[1].imageUrl ?: String.EMPTY

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

        cardMatch.setOnClickListener {
            routerToDetail()
        }
    }

    private fun routerToDetail() {

        val intent = Intent(context, MatchTeamActivity::class.java)
        val bundle = Bundle()

        bundle.putString(MatchTeamActivity.LEAGUE_NAME, leagueName.text.toString())
        bundle.putString(MatchTeamActivity.TEAM_A_NAME, textTeamHomeName.text.toString())
        bundle.putString(MatchTeamActivity.TEAM_B_NAME, textTeamGuestName.text.toString())
        bundle.putString(MatchTeamActivity.TEAM_A_IMAGE, imageTeamA)
        bundle.putString(MatchTeamActivity.TEAM_B_IMAGE, imageTeamB)

        context.startActivity(intent, bundle)
    }

    companion object {
        fun create(parent: ViewGroup, context: Context): MatchViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemMatchBinding = ItemMatchBinding.inflate(inflater, parent, false)
            return MatchViewHolder(itemMatchBinding, context)
        }
    }
}
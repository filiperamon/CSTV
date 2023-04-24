package com.example.cstv.presentation.match.players

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.model.Team
import com.example.cstv.databinding.ItemTeamsBinding

class TeamViewHolder(
    itemTeamBinding: ItemTeamsBinding,
    private val context: Context
): RecyclerView.ViewHolder(itemTeamBinding.root) {

    fun bind(team: Team) {

    }

    companion object {
        fun create(parent: ViewGroup, context: Context): TeamViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemMatchBinding = ItemTeamsBinding.inflate(inflater, parent, false)
            return TeamViewHolder(itemMatchBinding, context)
        }
    }
}
package com.example.cstv.presentation.match.players

import android.content.Context
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Team

class TeamAdapter(
    private val context: Context
): PagingDataAdapter<Team, TeamViewHolder>(differCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder.create(parent, context)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(
                oldItem: Team,
                newItem: Team
            ): Boolean {
                return oldItem.teamId == newItem.teamId
            }

            override fun areContentsTheSame(
                oldItem: Team,
                newItem: Team
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
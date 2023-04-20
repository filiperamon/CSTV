package com.example.cstv.presentation.match.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Match

class MatchAdapter(
    private val context: Context
): PagingDataAdapter<Match, MatchViewHolder>(differCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder.create(parent, context)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<Match>() {
            override fun areItemsTheSame(
                oldItem: Match,
                newItem: Match
            ): Boolean {
                return oldItem.game == newItem.game
            }

            override fun areContentsTheSame(
                oldItem: Match,
                newItem: Match
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
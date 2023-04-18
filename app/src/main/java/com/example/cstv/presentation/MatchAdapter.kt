package com.example.cstv.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Match

class MatchAdapter: ListAdapter<Match, MatchViewHolder>(differCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<Match>() {
            override fun areItemsTheSame(
                oldItem: Match,
                newItem: Match
            ): Boolean {
                return oldItem.league == newItem.league
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
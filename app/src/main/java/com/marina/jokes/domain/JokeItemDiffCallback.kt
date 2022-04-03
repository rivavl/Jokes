package com.marina.jokes.domain

import androidx.recyclerview.widget.DiffUtil
import com.marina.jokes.domain.entity.Joke

class JokeItemDiffCallback : DiffUtil.ItemCallback<Joke>() {
    override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem == newItem
    }
}
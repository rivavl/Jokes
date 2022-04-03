package com.marina.jokes.presentation.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.marina.jokes.R
import com.marina.jokes.domain.JokeItemDiffCallback
import com.marina.jokes.domain.entity.Joke

class JokesAdapter :
    ListAdapter<Joke, JokeViewHolder>(JokeItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val layout = R.layout.rv_item
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: JokeViewHolder, position: Int) {
        val jokeItem = getItem(position)
        viewHolder.value.text = jokeItem.value
    }
}
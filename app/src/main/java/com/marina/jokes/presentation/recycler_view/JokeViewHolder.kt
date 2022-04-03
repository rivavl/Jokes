package com.marina.jokes.presentation.recycler_view

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.marina.jokes.R

class JokeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val value = view.findViewById<AppCompatTextView>(R.id.text_value_joke)
}
package com.marina.jokes.data.mappers

import com.marina.jokes.data.entity.JokeItem
import com.marina.jokes.domain.entity.Joke

object MapperJokeItemToJoke {

    fun jokeItemToJoke(joke: JokeItem): Joke {
        return Joke(id = joke.id, value = joke.value)
    }
}
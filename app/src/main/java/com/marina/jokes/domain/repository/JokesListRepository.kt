package com.marina.jokes.domain.repository

import com.marina.jokes.domain.entity.Joke

interface JokesListRepository {

    suspend fun getJokesList(amount: Int): List<Joke>
}
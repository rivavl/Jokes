package com.marina.jokes.domain.usecase

import com.marina.jokes.domain.entity.Joke
import com.marina.jokes.domain.repository.JokesListRepository

class GetJokesListUseCase(private val jokesListRepository: JokesListRepository) {

    suspend operator fun invoke(amount: Int): List<Joke> {
        return jokesListRepository.getJokesList(amount)
    }
}
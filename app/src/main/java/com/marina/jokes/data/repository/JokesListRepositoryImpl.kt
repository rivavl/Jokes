package com.marina.jokes.data.repository

import com.marina.jokes.data.api.RetrofitInstance
import com.marina.jokes.data.mappers.MapperJokeItemToJoke
import com.marina.jokes.domain.entity.Joke
import com.marina.jokes.domain.repository.JokesListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class JokesListRepositoryImpl : JokesListRepository {

    override suspend fun getJokesList(amount: Int): List<Joke> {
        val mutableList = mutableListOf<Joke>()
        var i = 0
        while (i < amount) {
            val request = RetrofitInstance.api.getRandomJoke()
            val item = MapperJokeItemToJoke.jokeItemToJoke(
                request.body()!!
            )
            mutableList.add(item)
            i++
        }

        return mutableList
    }

}

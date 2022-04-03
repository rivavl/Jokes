package com.marina.jokes.data.api

import com.marina.jokes.data.entity.JokeItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("random")
    suspend fun getRandomJoke(): Response<JokeItem>

}
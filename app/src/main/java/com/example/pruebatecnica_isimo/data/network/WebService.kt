package com.example.pruebatecnica_isimo.data.network

import CharacterList
import retrofit2.http.GET
import retrofit2.http.Url

interface WebService {
    @GET
    suspend fun fetchCharacters(@Url url: String): CharacterList
}
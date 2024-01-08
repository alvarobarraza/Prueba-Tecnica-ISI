package com.example.pruebatecnica_isimo.data

import CharacterList
import com.example.pruebatecnica_isimo.data.network.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {

    private var webService: WebService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        webService = retrofit.create(WebService::class.java)
    }

    suspend fun fetchCharacters(url: String): CharacterList {
        return webService.fetchCharacters(url)
    }
}
package com.dgd.superheroes.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface HeroeApiService {
    @GET("heroes.json")
    suspend fun getHeroes(): Response<List<HeroeApiModel>>
}
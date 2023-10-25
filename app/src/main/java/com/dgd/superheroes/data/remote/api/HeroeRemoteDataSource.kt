package com.dgd.superheroes.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface HeroeRemoteDataSource {
    @GET("heroes.json")
    suspend fun getSuperheroe(): Response<HeroeApiModel>
}
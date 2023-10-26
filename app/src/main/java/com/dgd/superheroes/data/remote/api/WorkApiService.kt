package com.dgd.superheroes.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface WorkApiService {
    @GET("work.json")
    suspend fun getWork(): Response<WorkApiModel>
}
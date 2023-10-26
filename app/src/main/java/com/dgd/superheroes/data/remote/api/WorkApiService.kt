package com.dgd.superheroes.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WorkApiService {
    @GET("work/{id}.json")
    suspend fun getWork(@Path("id") id : Int): Response<WorkApiModel>
}
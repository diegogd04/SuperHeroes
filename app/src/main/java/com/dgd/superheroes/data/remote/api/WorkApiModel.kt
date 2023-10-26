package com.dgd.superheroes.data.remote.api

import com.google.gson.annotations.SerializedName

data class WorkApiModel(
    @SerializedName("occupation") val occupation: String,
    @SerializedName("base") val base: String
)
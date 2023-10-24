package com.dgd.superheroes.data.remote.api

import com.google.gson.annotations.SerializedName

data class SuperheroeApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String
)
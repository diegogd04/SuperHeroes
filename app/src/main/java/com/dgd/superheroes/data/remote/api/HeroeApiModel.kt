package com.dgd.superheroes.data.remote.api

import com.google.gson.annotations.SerializedName

data class HeroeApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String? = null,
    @SerializedName("powerstats") val powerstats: Powerstats,
    @SerializedName("apperance") val apperance: Appearance,
    @SerializedName("images") val images: Images
) {
    data class Powerstats(
        @SerializedName("intelligence") val intelligence: Int,
        @SerializedName("strength") val strength: Int,
        @SerializedName("speed") val speed: Int,
        @SerializedName("darbility") val durability: Int,
        @SerializedName("power") val power: Int,
        @SerializedName("combat") val combat: Int
    )

    data class Appearance(
        @SerializedName("gender") val gender: String,
        @SerializedName("race") val race: String?,
        @SerializedName("height") val height: List<String>,
        @SerializedName("weight") val weight: List<String>,
        @SerializedName("eyeColor") val eyeColor: String,
        @SerializedName("hairColor") val hairColor: String
    )

    data class Images(
        @SerializedName("xs") val xs: String,
        @SerializedName("sm") val sm: String,
        @SerializedName("md") val md: String,
        @SerializedName("lg") val lg: String
    )
}
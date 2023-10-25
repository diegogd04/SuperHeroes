package com.dgd.superheroes.domain

data class Heroe(
    val id: Int,
    val name: String,
    val slug: String? = null,
    val powerstats: Powerstats,
    val appearance: Appearance,
    val images: Images
){
    data class Powerstats(
        val intelligence: Int,
        val strength: Int,
        val speed: Int,
        val durability: Int,
        val power: Int,
        val combat: Int
    )

    data class Appearance(
        val gender: String,
        val race: String?,
        val height: List<String>,
        val weight: List<String>,
        val eyeColor: String,
        val hairColor: String
    )

    data class Images(
        val xs: String,
        val sm: String,
        val md: String,
        val lg: String
    )
}
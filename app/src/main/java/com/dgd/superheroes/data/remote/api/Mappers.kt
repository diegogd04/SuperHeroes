package com.dgd.superheroes.data.remote.api

import com.dgd.superheroes.domain.Heroe

fun HeroeApiModel.toModel(): Heroe =
    Heroe(this.id, this.name, this.slug, this.powerstats.toModel(), this.apperance.toModel(), this.images.toModel())

fun HeroeApiModel.Powerstats.toModel(): Heroe.Powerstats =
    Heroe.Powerstats(this.intelligence, this.strength, this.speed, this.durability, this.power, this.combat)

fun HeroeApiModel.Appearance.toModel(): Heroe.Appearance =
    Heroe.Appearance(this.gender, this.race, this.height, this.weight, this.eyeColor, this.hairColor)

fun HeroeApiModel.Images.toModel(): Heroe.Images =
    Heroe.Images(this.xs, this.sm, this.md, this.lg)
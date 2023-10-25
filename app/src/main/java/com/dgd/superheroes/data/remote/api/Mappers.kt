package com.dgd.superheroes.data.remote.api

import com.dgd.superheroes.domain.Heroe

fun HeroeApiModel.toModel(): Heroe =
    Heroe(this.id, this.name, this.images)

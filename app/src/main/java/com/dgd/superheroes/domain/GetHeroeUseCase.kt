package com.dgd.superheroes.domain

import com.dgd.superheroes.app.Either
import com.dgd.superheroes.app.ErrorApp

class GetHeroeUseCase(private val repository: HeroeRepository) {
    suspend operator fun invoke(): Either<ErrorApp, List<Heroe>>{
        return repository.obtain()
    }
}
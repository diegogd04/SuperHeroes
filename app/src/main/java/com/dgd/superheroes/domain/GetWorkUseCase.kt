package com.dgd.superheroes.domain

import com.dgd.superheroes.app.Either
import com.dgd.superheroes.app.ErrorApp

class GetWorkUseCase(private val repository: WorkRepository){
    suspend operator fun invoke(id: Int): Either<ErrorApp, Work> {
        return repository.obtain(id)
    }
}
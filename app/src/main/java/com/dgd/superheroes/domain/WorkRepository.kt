package com.dgd.superheroes.domain

import com.dgd.superheroes.app.Either
import com.dgd.superheroes.app.ErrorApp

interface WorkRepository {
    suspend fun obtain(id: Int): Either<ErrorApp, Work>
}
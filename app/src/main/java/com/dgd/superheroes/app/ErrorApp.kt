package com.dgd.superheroes.app

sealed class ErrorApp {
    object UncknowError : ErrorApp()
    object DataError : ErrorApp()
    object NetworkError : ErrorApp()
}
package com.dgd.superheroes.app

sealed class ErrorApp {
    object UncknowError : ErrorApp()
}
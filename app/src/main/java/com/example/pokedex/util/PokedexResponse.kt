package com.example.pokedex.util

sealed class PokedexResponse(message: String? = null) {
    class Success(message: String? = null): PokedexResponse(message)
    class Error(message: String): PokedexResponse(message = message)
    class Loading(): PokedexResponse()
}
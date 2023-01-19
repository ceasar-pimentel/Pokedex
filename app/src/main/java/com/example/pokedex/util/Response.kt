package com.example.pokedex.util

sealed class Response<T>(val data:T? = null, val message: String? = null) {
    class Success<T>(data: T?= null): Response<T>(data)
    class Error<T>(message: String, data:T?= null): Response<T>(message = message, data = data)
}
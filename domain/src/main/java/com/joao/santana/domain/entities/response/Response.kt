package com.joao.santana.domain.entities.response

sealed class Response<T> {

    data class Success<T>(val body: T) : Response<T>()

    data class Error<T>(val message: String?) : Response<T>()
}
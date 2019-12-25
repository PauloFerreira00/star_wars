package com.joao.santana.infrastructure.helpers

interface NetworkConnection {

    fun hasActiveInternetConnection(): Boolean
}
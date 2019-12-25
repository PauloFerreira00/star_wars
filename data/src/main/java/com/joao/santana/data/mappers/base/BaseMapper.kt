package com.joao.santana.data.mappers.base

interface BaseMapper <in Input, out Output> {

    fun map(input: Input): Output
}
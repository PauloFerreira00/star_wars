package com.joao.santana.data.extensions

import retrofit2.Response
import com.joao.santana.data.mappers.base.BaseMapper
import com.joao.santana.domain.entities.response.Response as ResponseEntity

fun <T, O> Response<T>.mapToResponseEntity(mapper: BaseMapper<T, O>): ResponseEntity<O> {
    return when {
        isSuccessful && code() == 200 -> ResponseEntity.Success(mapper.map(body()!!))
        else -> ResponseEntity.Error(this.message())
    }
}
package com.joao.santana.infrastructure.helpers

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiHelperImpl : MoshiHelper {

    override fun build(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}
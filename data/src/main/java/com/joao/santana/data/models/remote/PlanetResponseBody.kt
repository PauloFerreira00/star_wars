package com.joao.santana.data.models.remote

import com.google.gson.annotations.SerializedName

data class PlanetResponseBody(
    @SerializedName(NAME) val name: String?
) {

    private companion object {
        private const val NAME: String = "name"
    }
}
package com.joao.santana.data.models.remote

import com.google.gson.annotations.SerializedName

data class PeopleResponseBody(
    @SerializedName(NAME) val name: String?,
    @SerializedName(MASS) val mass: String?,
    @SerializedName(HEIGHT) val height: String?,
    @SerializedName(GENDER) val gender: String?
) {

    private companion object {
        private const val NAME: String = "name"
        private const val MASS: String = "mass"
        private const val HEIGHT: String = "height"
        private const val GENDER: String = "gender"
    }
}
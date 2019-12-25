package com.joao.santana.data.models.remote

import com.google.gson.annotations.SerializedName

data class PeoplesResponseBody(
    @SerializedName(COUNT) val count: Long?,
    @SerializedName(NEXT) val next: String?,
    @SerializedName(PREVIOUS) val previous: String?,
    @SerializedName(RESULTS) val results: List<PeopleResponseBody>?
) {

    private companion object {
        private const val COUNT: String = "count"
        private const val NEXT: String = "next"
        private const val PREVIOUS: String = "previous"
        private const val RESULTS: String = "results"
    }
}
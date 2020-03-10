package com.krit.appforkrit.model.nw.weather

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwPressureTendency (
    @field:Json(name = "LocalizedText")
    val localizedText: String,

    @field:Json(name = "Code")
    val code: String
)

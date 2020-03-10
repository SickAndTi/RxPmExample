package com.krit.appforkrit.model.nw.city

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NwCity(
    @field:Json(name = "Version")
    val version: Int,

    @field:Json(name = "Key")
    val key: String,

    @field:Json(name = "Type")
    val type: String,

    @field:Json(name = "Rank")
    val rank: Int,

    @field:Json(name = "LocalizedName")
    val localizedName: String,

    @field:Json(name = "Country")
    val country: NwCountry,

    @field:Json(name = "AdministrativeArea")
    val administrativeArea: NwAdministrativeArea
)
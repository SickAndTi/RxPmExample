package com.krit.appforkrit.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "cities"
)
data class City (
    @PrimaryKey(autoGenerate = false)
    val locationKey: String,

    val cityName: String,
    val countryName: String
)
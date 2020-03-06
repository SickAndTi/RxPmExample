package com.krit.appforkrit.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class City (
    @PrimaryKey
    val id: Int,

    val name: String
)
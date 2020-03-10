package com.krit.appforkrit.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weathers")
data class Weather (
    @PrimaryKey
    val id: Int


)
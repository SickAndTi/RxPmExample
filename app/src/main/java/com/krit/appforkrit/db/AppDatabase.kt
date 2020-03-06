package com.krit.appforkrit.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.krit.appforkrit.db.dao.CityDao
import com.krit.appforkrit.model.db.City

@Database(
    entities = [City::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cityDao(): CityDao
}

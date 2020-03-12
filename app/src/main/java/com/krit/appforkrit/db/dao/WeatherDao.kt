package com.krit.appforkrit.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krit.appforkrit.model.db.Weather
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weathers")
    fun getAll(): Flowable<List<Weather>>

    @Query("SELECT * FROM weathers WHERE locationKey = :locationKey ")
    fun getOneByLocationKey(locationKey: String): Single<Weather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(listWeather: List<Weather>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weather: Weather)

}
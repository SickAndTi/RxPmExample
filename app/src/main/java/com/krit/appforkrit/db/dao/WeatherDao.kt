package com.krit.appforkrit.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.krit.appforkrit.model.db.Weather
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weathers")
    fun getAll(): Flowable<List<Weather>>

    @Query("SELECT * FROM weathers WHERE id = :id ")
    fun getOneById(id: Long): Single<Weather>

}
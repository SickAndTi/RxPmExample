package com.krit.appforkrit.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.krit.appforkrit.model.db.City
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun getAll(): Flowable<List<City>>

    @Query("SELECT * FROM cities WHERE id = :id ")
    fun getOneById(id: Long): Single<City>
}
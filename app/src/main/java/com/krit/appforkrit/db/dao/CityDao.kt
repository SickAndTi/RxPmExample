package com.krit.appforkrit.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.krit.appforkrit.model.db.City
import com.krit.appforkrit.ui.adapter.view_model.CityInListViewModel
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun getAll(): Flowable<List<City>>

    @Query("SELECT * FROM cities WHERE locationKey = :locationKey ")
    fun getOneByLocationKey(locationKey: String): Single<City>

    @Insert(onConflict = REPLACE)
    fun insertAll(listCities: List<City>)

    @Query("""
             SELECT c.locationKey, c.name as cityName, c.countryName, w.temperature, w.weatherDesc 
             FROM cities c 
             JOIN weathers w ON w.locationKey = c.locationKey 
             WHERE c.locationKey IN (:locationKeys)
        """)
    fun getCitiesWithWeatherByLocationKeys(locationKeys: List<String>): Single<List<CityInListViewModel>>

    @Query("""
             SELECT c.locationKey, c.name as cityName, c.countryName, w.temperature, w.weatherDesc 
             FROM cities c 
             JOIN weathers w ON w.locationKey = c.locationKey
        """)
    fun getCitiesWithWeather(): Single<List<CityInListViewModel>>

}

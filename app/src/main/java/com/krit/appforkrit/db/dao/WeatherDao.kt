package com.krit.appforkrit.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krit.appforkrit.model.db.Weather
import com.krit.appforkrit.model.view_model.WeatherViewModel
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

    @Query("""
             SELECT c.name as cityName, c.countryName, w.temperature, w.weatherDesc, w.isDayTime, 
             w.localObservationDateTime, w.pressure, w.relativeHumidity, w.visibility, w.windDirection, w.windSpeed
             FROM weathers w 
             JOIN cities c ON w.locationKey = c.locationKey 
             WHERE w.locationKey =:locationKey
        """)
    fun getWeatherAndCityByLocationKey(locationKey: String): Single<WeatherViewModel>

}
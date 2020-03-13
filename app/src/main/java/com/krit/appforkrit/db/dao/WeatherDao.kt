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
             SELECT c.cityName, c.countryName, w.temperature, w.temperatureType, w.weatherDesc, w.isDayTime, 
             w.localObservationDateTime, w.pressure, w.pressureType, w.relativeHumidity, w.visibility, w.visibilityType, w.windDirection, w.windSpeed, w.windSpeedType
             FROM weathers w 
             LEFT OUTER JOIN cities c ON w.locationKey = c.locationKey 
             WHERE w.locationKey =:locationKey
        """)
    fun getWeatherAndCityByLocationKey(locationKey: String): Single<WeatherViewModel>

}
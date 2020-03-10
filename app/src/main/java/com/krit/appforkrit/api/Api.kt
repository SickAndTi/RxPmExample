package com.krit.appforkrit.api

import com.krit.appforkrit.model.nw.city.NwCity
import com.krit.appforkrit.model.nw.weather.NwWeather
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("locations/v1/cities/search")
    fun searchCities(
        @Query("q") textToSearch: String
    ): Single<List<NwCity>>

    @GET("locations/v1/cities/autocomplete")
    fun autocompleteCities(
        @Query("q") textToSearch: String
    ): Single<List<NwCity>>

    @GET("currentconditions/v1/{locationKey}")
    fun getWeatherByLocationKey(
        @Query("details") fullInfo: Boolean,
        @Path("locationKey") locationKey: String
    ): Single<NwWeather>
}
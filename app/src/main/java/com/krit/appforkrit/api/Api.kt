package com.krit.appforkrit.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("locations/v1/cities/search")
    fun searchCities(
        @Query("q") textToSearch: String
    ): List<NwCity>

    @GET("forecasts/v1/daily/1day/{locationKey}")
    fun getWeatherByLocationKey(
        @Path("locationKey") locationKey: String

    ): NwWeather

}
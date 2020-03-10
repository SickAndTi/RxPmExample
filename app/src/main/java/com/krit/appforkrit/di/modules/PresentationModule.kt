package com.krit.appforkrit.di.modules

import com.krit.appforkrit.presentation.CityListPm
import com.krit.appforkrit.presentation.SingleCityPm
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideCityListPm() = CityListPm()

    @Provides
    fun provideSingleCityPm() = SingleCityPm()
}
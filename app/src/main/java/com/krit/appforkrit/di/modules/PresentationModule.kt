package com.krit.appforkrit.di.modules

import com.krit.appforkrit.presentation.CityListPm
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideCityListPm() = CityListPm()
}
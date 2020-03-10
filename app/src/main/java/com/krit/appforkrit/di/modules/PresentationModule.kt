package com.krit.appforkrit.di.modules

import com.krit.appforkrit.domain.citylist.CityListInteractor
import com.krit.appforkrit.presentation.CityListPm
import com.krit.appforkrit.presentation.SingleCityPm
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideCityListPm(interactor: CityListInteractor) = CityListPm(interactor)

    @Provides
    fun provideSingleCityPm() = SingleCityPm()

}
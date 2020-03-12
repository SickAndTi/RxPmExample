package com.krit.appforkrit.di.modules

import com.krit.appforkrit.domain.citylist.CityListInteractor
import com.krit.appforkrit.domain.weather.WeatherInteractor
import com.krit.appforkrit.presentation.CityListPm
import com.krit.appforkrit.presentation.SingleCityPm
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router

@Module
class PresentationModule {

    @Provides
    fun provideCityListPm(interactor: CityListInteractor, router: Router) = CityListPm(interactor, router)

    @Provides
    fun provideSingleCityPm(interactor: WeatherInteractor, router: Router) = SingleCityPm(interactor, router)

}
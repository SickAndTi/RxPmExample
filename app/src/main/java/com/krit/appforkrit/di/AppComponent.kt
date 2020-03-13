package com.krit.appforkrit.di

import com.krit.appforkrit.di.modules.*
import com.krit.appforkrit.ui.activity.MainActivity
import com.krit.appforkrit.ui.fragment.CityListFragment
import com.krit.appforkrit.ui.fragment.WeatherFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        StorageModule::class,
        NavigationModule::class,
        PresentationModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: CityListFragment)
    fun inject(fragment: WeatherFragment)

}
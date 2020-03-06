package com.krit.appforkrit.di

import com.krit.appforkrit.di.modules.*
import com.krit.appforkrit.ui.activity.MainActivity
import dagger.Component

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

}
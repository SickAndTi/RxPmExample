package com.krit.appforkrit.di.modules

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
class NavigationModule {

    @Provides
    fun provideCicerone() = Cicerone.create(Router())

    @Provides
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder
}
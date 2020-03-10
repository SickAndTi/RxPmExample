package com.krit

import android.app.Application
import com.krit.appforkrit.di.AppComponent
import com.krit.appforkrit.di.DaggerAppComponent
import com.krit.appforkrit.di.modules.*
import timber.log.Timber

class App: Application() {

    companion object {
        lateinit var COMPONENT: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        COMPONENT = initDi()
    }

    private fun initDi(): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .navigationModule(NavigationModule())
            .networkModule(NetworkModule())
            .storageModule(StorageModule(this))
            .presentationModule(PresentationModule())
            .build()

}
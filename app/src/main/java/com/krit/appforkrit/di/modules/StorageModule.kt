package com.krit.appforkrit.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.krit.appforkrit.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class StorageModule(
    private val context: Context
) {

    @Provides
    fun providePreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun provideDataBase() = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database"
        )
        .build()

}
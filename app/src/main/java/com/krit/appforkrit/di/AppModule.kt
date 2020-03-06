package com.krit.appforkrit.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.krit.appforkrit.AppConstants
import com.krit.appforkrit.db.AppDatabase
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import timber.log.Timber
import java.util.*

@Module
class AppModule(
    private val context: Context
) {
    @Provides
    fun provideContext() = context

    @Provides
    fun provideOkhhtp() = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
                override fun log(message: String) {
                    Timber.tag("OkHttp").d(message)
                }
            })
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi):Retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    fun providePreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun provideDataBase() = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database"
        )
        .build()

    @Provides
    fun provideCicerone() = Cicerone.create(Router())

    @Provides
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<Router>) = cicerone.navigatorHolder

}

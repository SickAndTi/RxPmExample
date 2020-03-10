package com.krit.appforkrit.di.modules

import com.krit.appforkrit.AppConstants
import com.krit.appforkrit.api.Api
import com.krit.appforkrit.api.ApiClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import timber.log.Timber
import java.util.*

@Module
class NetworkModule {

    @Provides
    fun provideOkhhtp(interceptor: Interceptor) = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger{
                override fun log(message: String) {
                    Timber.tag("OkHttp").d(message)
                }
            })
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .addInterceptor(interceptor)
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
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
    fun provideInterceptor() = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val url = request.url.newBuilder()
                .addQueryParameter("apikey", AppConstants.API_KEY)
                .build()

            val response = chain.proceed(request
                .newBuilder()
                .url(url)
                .build()
            )
            return response
        }
    }

    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(Api::class.java)
}
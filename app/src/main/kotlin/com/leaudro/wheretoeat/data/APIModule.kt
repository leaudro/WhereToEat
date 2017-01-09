package com.leaudro.wheretoeat.data

import com.google.gson.GsonBuilder
import com.leaudro.wheretoeat.BuildConfig
import com.leaudro.wheretoeat.data.remote.APIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class APIModule() {

    @Provides
    @Singleton
    fun provideAPIService(): APIService {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .baseUrl(BuildConfig.API_URL)
                .build()

        return retrofit.create(APIService::class.java)
    }
}
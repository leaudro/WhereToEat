package com.leaudro.wheretoeat.data

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providePlaceRepository(): PlacesDataSource = PlacesRepository()
}
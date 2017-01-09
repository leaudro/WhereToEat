package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.App
import com.leaudro.wheretoeat.data.remote.APIService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providePlaceRepository(api: APIService,
                               app: App): PlacesDataSource = PlacesRepository(api, app)
}
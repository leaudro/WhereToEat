package com.leaudro.wheretoeat

import android.content.Context
import com.leaudro.wheretoeat.data.DataModule
import com.leaudro.wheretoeat.ui.PresenterModule
import com.leaudro.wheretoeat.ui.UiComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {
    fun inject(app: App)
    operator fun plus(presenterModule: PresenterModule): UiComponent
}

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApp(): App = app
}

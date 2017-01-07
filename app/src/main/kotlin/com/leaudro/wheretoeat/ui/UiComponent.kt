package com.leaudro.wheretoeat.ui

import com.leaudro.wheretoeat.data.PlacesDataSource
import com.leaudro.wheretoeat.ui.places.PlacesContract
import com.leaudro.wheretoeat.ui.places.PlacesPresenter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(PresenterModule::class))
interface UiComponent {
    fun inject(activity: BaseActivity)
}

@Module
open class PresenterModule(private val view: BaseView) {

    @Provides
    @Singleton
    fun providePlacesPresenter(dataSource: PlacesDataSource): PlacesPresenter {
        if (view !is PlacesContract.View) {
            throw AssertionError("Should be a PlacesView for this presenter")
        }

        return PlacesPresenter(view, dataSource)
    }

}
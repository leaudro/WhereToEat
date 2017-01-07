package com.leaudro.wheretoeat.ui

import dagger.Module
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(PresenterModule::class))
interface UiComponent {
    fun inject(activity: BaseActivity)
}

@Module
open class PresenterModule(private val view: BaseView) {

}
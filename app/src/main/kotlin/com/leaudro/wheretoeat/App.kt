package com.leaudro.wheretoeat

import android.app.Application
import android.content.Context

class App : Application() {

    lateinit var appComponent: AppComponent

    companion object {
        const val PREF_NAME = "pref_user"
        const val PREF_NAME_FIELD = "user"

    }

    var userName: String
        get() = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(PREF_NAME_FIELD, "")
        set(value) {
            getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                    .edit().putString(PREF_NAME_FIELD, value).apply()
        }

    override fun onCreate() {
        super.onCreate()

        buildComponent()
    }

    fun buildComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}
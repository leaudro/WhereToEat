package com.leaudro.wheretoeat.ui

import android.support.v7.app.AppCompatActivity
import com.leaudro.wheretoeat.App
import com.leaudro.wheretoeat.AppComponent

abstract class BaseActivity : AppCompatActivity() {
    fun getAppComponent(): AppComponent = (application as App).appComponent
}

interface BaseView {
    fun showLoadingIndicator(isLoading: Boolean)
}
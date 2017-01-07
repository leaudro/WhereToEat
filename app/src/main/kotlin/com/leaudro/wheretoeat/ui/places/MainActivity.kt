package com.leaudro.wheretoeat.ui.places

import android.os.Bundle
import com.leaudro.wheretoeat.R
import com.leaudro.wheretoeat.data.model.Place
import com.leaudro.wheretoeat.ui.BaseActivity
import com.leaudro.wheretoeat.ui.PresenterModule
import com.leaudro.wheretoeat.ui.UiComponent
import javax.inject.Inject

class MainActivity : BaseActivity(), PlacesContract.View {

    lateinit var uiComponent: UiComponent

    @Inject
    lateinit var presenter: PlacesContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uiComponent = getAppComponent() + PresenterModule(this)

        uiComponent.inject(this)

        presenter.fetchPlaces()
    }

    override fun showPlaces(list: List<Place>) {

    }

    override fun showLoadingIndicator(isLoading: Boolean) {

    }

    override fun showEmptyList() {

    }
}
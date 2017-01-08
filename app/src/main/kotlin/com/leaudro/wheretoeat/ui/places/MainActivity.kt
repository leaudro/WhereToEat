package com.leaudro.wheretoeat.ui.places

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.leaudro.wheretoeat.R
import com.leaudro.wheretoeat.data.model.Place
import com.leaudro.wheretoeat.ui.BaseActivity
import com.leaudro.wheretoeat.ui.PresenterModule
import com.leaudro.wheretoeat.ui.UiComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_places_list.*
import kotlinx.android.synthetic.main.loading_indicator.*
import javax.inject.Inject

class MainActivity : BaseActivity(), PlacesContract.View {

    lateinit var uiComponent: UiComponent

    @Inject
    lateinit var presenter: PlacesContract.Presenter

    lateinit var adapter: PlacesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        uiComponent = getAppComponent() + PresenterModule(this)
        uiComponent.inject(this)

        setupRecyclerView()

        presenter.fetchPlaces()
    }

    fun setupRecyclerView() {
        adapter = PlacesAdapter(this)
        placesRecyclerView.layoutManager = LinearLayoutManager(this)
        placesRecyclerView.adapter = adapter
        adapter.onButtonClicked  = { place: Place, i: Int ->
            //TODO on vote
        }
    }

    override fun showPlaces(list: List<Place>) {
        emptyText.visibility = View.GONE
        adapter.list = list
    }

    override fun showLoadingIndicator(isLoading: Boolean) {
        loadingIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun showEmptyList() {
        emptyText.setText(R.string.no_places_to_show)
        emptyText.visibility = View.VISIBLE
    }

    override fun blockVoting() {
        adapter.disableVotingButtons()
    }
}
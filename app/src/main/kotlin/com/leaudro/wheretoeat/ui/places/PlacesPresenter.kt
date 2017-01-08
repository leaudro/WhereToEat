package com.leaudro.wheretoeat.ui.places

import com.leaudro.wheretoeat.data.PlacesDataSource
import com.leaudro.wheretoeat.data.model.Place
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class PlacesPresenter(val view: PlacesContract.View,
                      val dataSource: PlacesDataSource) : PlacesContract.Presenter {

    override fun fetchPlaces() {
        view.showLoadingIndicator(true)

        dataSource.getPlaces()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate {
                    view.showLoadingIndicator(false)
                }
                .subscribe({ places ->
                    if (places.isEmpty()) {
                        view.showEmptyList()
                    } else {
                        view.showPlaces(places)
                    }
                    if (places.any { it.votedByYou }) {
                        view.blockVoting()
                    }
                }, { error ->
                    //TODO handle errors
                })

    }

    override fun vote(place: Place) {
        view.showLoadingIndicator(true)

        dataSource.addVote(place)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate {
                    view.showLoadingIndicator(false)
                }
                .subscribe({ place ->
                    place?.let {
                        view.updatePlace(it)
                        view.blockVoting()
                    }
                }, { error ->
                })
    }
}
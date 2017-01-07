package com.leaudro.wheretoeat

import com.leaudro.wheretoeat.data.PlacesDataSource
import com.leaudro.wheretoeat.data.model.Place
import com.leaudro.wheretoeat.ui.places.PlacesContract
import com.leaudro.wheretoeat.ui.places.PlacesPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class PlacePresenterTest {

    lateinit var view: PlacesContract.View
    lateinit var presenter: PlacesContract.Presenter
    lateinit var dataSource: PlacesDataSource

    private val PLACES_LIST: List<Place> = listOf(
            Place(0),
            Place(1)
    )

    @Before
    fun setup() {
        view = mock()
        dataSource = mock()
        presenter = PlacesPresenter(view, dataSource)
    }

    @Test
    fun shouldGetAndShowPlaceList() {

        `when`(dataSource.getPlaces())
                .thenReturn(PLACES_LIST)

        presenter.fetchPlaces()

        verify(view).showLoadingIndicator(true)
        verify(dataSource).getPlaces()
        verify(view).showPlaces(PLACES_LIST)
        verify(view).showLoadingIndicator(false)
    }

    @Test
    fun shouldShowEmptyList() {

        `when`(dataSource.getPlaces())
                .thenReturn(emptyList())

        presenter.fetchPlaces()

        verify(view).showLoadingIndicator(true)
        verify(dataSource).getPlaces()
        verify(view).showEmptyList()
        verify(view).showLoadingIndicator(false)
    }
}
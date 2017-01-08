package com.leaudro.wheretoeat

import com.leaudro.wheretoeat.data.PlacesDataSource
import com.leaudro.wheretoeat.data.model.Place
import com.leaudro.wheretoeat.ui.places.PlacesContract
import com.leaudro.wheretoeat.ui.places.PlacesPresenter
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import rx.lang.kotlin.toSingletonObservable

class PlacePresenterTest {

    @Rule @JvmField
    val rxField = RxSchedulersOverrideRule()

    lateinit var view: PlacesContract.View
    lateinit var presenter: PlacesContract.Presenter
    lateinit var dataSource: PlacesDataSource

    private val PLACES_LIST = listOf(
            Place(0),
            Place(1)
    )

    private val PLACES_WITH_ITEM_VOTED = PLACES_LIST
            .mapIndexed { i, place -> place.copy(votedByYou = i == 0) }

    @Before
    fun setup() {
        view = mock()
        dataSource = mock()
        presenter = PlacesPresenter(view, dataSource)
    }

    @Test
    fun shouldGetAndShowPlaceList() {

        `when`(dataSource.getPlaces())
                .thenReturn(PLACES_LIST.toSingletonObservable())

        presenter.fetchPlaces()

        verify(view).showLoadingIndicator(true)
        verify(dataSource).getPlaces()
        verify(view).showPlaces(PLACES_LIST)
        verify(view).showLoadingIndicator(false)
        verifyNoMoreInteractions(view, dataSource)
    }

    @Test
    fun shouldShowEmptyList() {

        `when`(dataSource.getPlaces())
                .thenReturn(emptyList<Place>().toSingletonObservable())

        presenter.fetchPlaces()

        verify(view).showLoadingIndicator(true)
        verify(dataSource).getPlaces()
        verify(view).showEmptyList()
        verify(view).showLoadingIndicator(false)
        verifyNoMoreInteractions(view, dataSource)
    }

    @Test
    fun shouldBlockVotingWhenUserAlreadyVoted() {

        `when`(dataSource.getPlaces())
                .thenReturn(PLACES_WITH_ITEM_VOTED
                        .toSingletonObservable())

        presenter.fetchPlaces()

        verify(view).showLoadingIndicator(true)
        verify(dataSource).getPlaces()
        verify(view).showPlaces(PLACES_WITH_ITEM_VOTED)
        verify(view).blockVoting()
        verify(view).showLoadingIndicator(false)
        verifyNoMoreInteractions(view, dataSource)
    }
}
package com.leaudro.wheretoeat.data

import com.leaudro.wheretoeat.App
import com.leaudro.wheretoeat.data.model.Place
import com.leaudro.wheretoeat.data.remote.APIService
import com.leaudro.wheretoeat.isSameWeekAsToday
import rx.Observable

class PlacesRepository(private val api: APIService,
                       private val app: App) : PlacesDataSource {

    override fun getPlaces(): Observable<List<Place>> {
        return api.getPlaces().map {
            it.map {
                return@map it.value.copy(id = it.key,
                        votesReceived = it.value.usersWhoVoted?.size ?: 0,
                        chosenThisWeek = it.value.lastDateChosen?.isSameWeekAsToday() ?: false,
                        votedByYou = it.value.usersWhoVoted?.contains(app.userName) ?: false)
            }.toMutableList()
        }
    }

    override fun addVote(place: Place): Observable<Place?>
            = api.voteForPlace(place.id, app.userName)
            .map {
                place.copy(
                        votedByYou = true,
                        votesReceived = place.votesReceived.plus(1)
                )
            }

    override fun getPlaceOfTheDay(): Observable<Place>
            = api.chosenPlaceToday()
            .map {
                it.copy(votesReceived = it.usersWhoVoted?.size ?: 0,
                        chosenThisWeek = it.lastDateChosen?.isSameWeekAsToday() ?: false,
                        votedByYou = it.usersWhoVoted?.contains(app.userName) ?: false)
            }
}
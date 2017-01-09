package com.leaudro.wheretoeat.data.model

import com.google.gson.annotations.SerializedName

data class Place(val id: String,
                 val name: String,
                 val description: String,
                 var votesReceived: Int,
                 var votedByYou: Boolean,
                 val chosenThisWeek: Boolean,
                 @SerializedName("votes_users") val usersWhoVoted: List<String>) {

    constructor(id: String): this(id, "", "",0, false, false, emptyList())

}
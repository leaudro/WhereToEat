package com.leaudro.wheretoeat.data.model

data class Place(val id: Long,
                 val name: String,
                 val description: String,
                 var votesReceived: Int,
                 var votedByYou: Boolean,
                 val chosenThisWeek: Boolean) {

    constructor(id: Long): this(id, "", "",0, false, false)

}
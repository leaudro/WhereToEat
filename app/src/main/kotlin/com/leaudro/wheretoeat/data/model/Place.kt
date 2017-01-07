package com.leaudro.wheretoeat.data.model

data class Place(val id: Long,
                 val name: String,
                 val description: String) {

    constructor(id: Long): this(id, "", "")

}
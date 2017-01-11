package com.leaudro.wheretoeat

import java.util.*

fun Date.isSameWeekAsToday(): Boolean {
    val today = Calendar.getInstance()
    val date = Calendar.getInstance()
    date.time = this
    return date[Calendar.YEAR] == today[Calendar.YEAR] &&
            date[Calendar.WEEK_OF_YEAR] == today[Calendar.WEEK_OF_YEAR]
}
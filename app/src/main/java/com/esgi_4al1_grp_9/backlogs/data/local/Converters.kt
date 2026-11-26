package com.esgi_4al1_grp_9.backlogs.data.local

import androidx.room.TypeConverter
class Converters {
    @TypeConverter
    fun idsToString(ids: List<Int>): String = ids.joinToString(",")

    @TypeConverter
    fun stringToIds(value: String): List<Int> =
        if (value.isBlank()) emptyList() else value.split(",").map { it.toInt() }
}
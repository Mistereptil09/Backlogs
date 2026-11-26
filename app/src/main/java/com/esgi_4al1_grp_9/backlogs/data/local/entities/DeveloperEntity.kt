package com.esgi_4al1_grp_9.backlogs.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "developers")
data class DeveloperEntity(
    @PrimaryKey val id: Int,
    val name: String
) {
    fun toDomain(): String = name
}

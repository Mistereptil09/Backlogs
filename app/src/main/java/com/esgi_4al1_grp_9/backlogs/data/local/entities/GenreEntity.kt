package com.esgi_4al1_grp_9.backlogs.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.esgi_4al1_grp_9.backlogs.domain.model.Genre

@Entity(tableName = "genres")
data class GenreEntity(
    @PrimaryKey val id: Int,
    val name: String
) {
    fun toDomain(): Genre = Genre(id = id, name = name)
}
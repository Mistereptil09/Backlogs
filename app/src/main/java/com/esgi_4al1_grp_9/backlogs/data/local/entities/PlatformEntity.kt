package com.esgi_4al1_grp_9.backlogs.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.esgi_4al1_grp_9.backlogs.domain.model.Platform

@Entity(tableName = "platforms")
data class PlatformEntity(
    @PrimaryKey val id: Int,
    val name: String
) {
    fun toDomain(): Platform = Platform(id = id, name = name)
}
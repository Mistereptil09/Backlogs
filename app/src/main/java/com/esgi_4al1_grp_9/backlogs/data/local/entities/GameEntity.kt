package com.esgi_4al1_grp_9.backlogs.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Cache of games fetched from RAWG.
 * Genres and platforms live in their own tables, linked through cross-reference tables.
 */
@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String?,
    val releaseDate: Long?,
    val tba: Boolean,
    val rating: Float,
    val ratingsCount: Int,
    val metacriticScore: Int?,
    val description: String?,
    val cachedAt: Long
)
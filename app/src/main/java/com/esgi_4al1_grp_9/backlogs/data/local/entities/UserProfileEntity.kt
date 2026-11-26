package com.esgi_4al1_grp_9.backlogs.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.esgi_4al1_grp_9.backlogs.domain.model.UserProfile


import java.time.LocalDate

/**
 * Single local profile: always one row with id = 1.
 * Preferences are stored as id lists (Converters), resolved against the genres/platforms tables.
 */
@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val id: Int = 1,
    val username: String,
    val createdAt: Long,                         // epoch day
    val favoriteGenreIds: List<Int> = emptyList(),
    val preferredPlatformIds: List<Int> = emptyList()
) {
    /** Unknown ids are silently ignored. */
    fun toDomain(
        allGenres: List<GenreEntity>,
        allPlatforms: List<PlatformEntity>
    ): UserProfile = UserProfile(
        username = username,
        createdAt = LocalDate.ofEpochDay(createdAt),
        favoriteGenres = allGenres
            .filter { it.id in favoriteGenreIds }
            .map { it.toDomain() },
        preferredPlatforms = allPlatforms
            .filter { it.id in preferredPlatformIds }
            .map { it.toDomain() }
    )

    companion object {
        fun fromDomain(profile: UserProfile) = UserProfileEntity(
            username = profile.username,
            createdAt = profile.createdAt.toEpochDay(),
            favoriteGenreIds = profile.favoriteGenres.map { it.id },
            preferredPlatformIds = profile.preferredPlatforms.map { it.id }
        )
    }
}
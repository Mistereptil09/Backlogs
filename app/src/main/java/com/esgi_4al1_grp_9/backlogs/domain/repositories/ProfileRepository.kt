package com.esgi_4al1_grp_9.backlogs.domain.repositories

import com.esgi_4al1_grp_9.backlogs.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun observeProfile(): Flow<UserProfile?>
    suspend fun createProfile(username: String)

    suspend fun changeUsername(name: String)

    // genre
    suspend fun addFavoriteGenre(genreId: Int)
    suspend fun removeFavoriteGenre(genreId: Int)

    // platform
    suspend fun addPreferredPlatform(platformId: Int)
    suspend fun removePreferredPlatform(platformId: Int)
}

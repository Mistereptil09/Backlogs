package com.esgi_4al1_grp_9.backlogs.domain.repositories

import com.esgi_4al1_grp_9.backlogs.domain.model.Game
import com.esgi_4al1_grp_9.backlogs.domain.model.Genre
import com.esgi_4al1_grp_9.backlogs.domain.model.Platform
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    // Lists (home, research, releases)
    suspend fun getPopularGames(page: Int): Result<List<Game>>
    suspend fun getNewReleases(page: Int): Result<List<Game>>
    suspend fun getUpcomingGames(page: Int): Result<List<Game>>
    suspend fun searchGames(
        query: String,
        genreIds: List<Int> = emptyList(),
        platformIds: List<Int> = emptyList(),
        page: Int
    ): Result<List<Game>>

    // Game data: observe the cache, refresh separately
    fun observeGame(id: Int): Flow<Game?>
    suspend fun refreshGame(id: Int): Result<Unit>

    // Filter values
    suspend fun getGenres(): Result<List<Genre>>
    suspend fun getPlatforms(): Result<List<Platform>>
}
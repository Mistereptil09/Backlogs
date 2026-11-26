package com.esgi_4al1_grp_9.backlogs.domain.repositories

import com.esgi_4al1_grp_9.backlogs.domain.model.BacklogEntry
import com.esgi_4al1_grp_9.backlogs.domain.model.BacklogItem
import com.esgi_4al1_grp_9.backlogs.domain.model.GameStatus
import kotlinx.coroutines.flow.Flow

interface BacklogRepository {
    // Read
    fun observeBacklog(): Flow<List<BacklogItem>>
    fun observeBacklogByStatus(status: GameStatus): Flow<List<BacklogItem>>
    fun observeEntry(gameId: Int): Flow<BacklogEntry?>   // detail screen: in my backlog or not

    // Write
    suspend fun addToBacklog(gameId: Int, status: GameStatus)
    suspend fun updateStatus(gameId: Int, status: GameStatus)
    suspend fun updateReview(gameId: Int, rating: Int?, comment: String?)
    suspend fun removeFromBacklog(gameId: Int)
}
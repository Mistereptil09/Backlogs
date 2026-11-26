package com.esgi_4al1_grp_9.backlogs.domain.model

import java.time.LocalDate

data class BacklogEntry(
    val gameId: Int,
    val status: GameStatus,
    val personalRating: Int?,
    val comment: String?,
    val addedAt: LocalDate,
    val finishedAt: LocalDate?
)
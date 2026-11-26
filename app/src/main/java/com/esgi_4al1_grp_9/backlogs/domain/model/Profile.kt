package com.esgi_4al1_grp_9.backlogs.domain.model

import java.time.LocalDate

data class UserProfile(
    val username: String,
    val createdAt: LocalDate,
    val favoriteGenres: List<Genre> = emptyList(),
    val preferredPlatforms: List<Platform> = emptyList()
)
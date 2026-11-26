package com.esgi_4al1_grp_9.backlogs.domain.model

import java.time.LocalDate

data class Game(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val releaseDate: LocalDate?,
    val tba: Boolean,
    val rating: Float,
    val ratingsCount: Int,
    val metacriticScore: Int?,
    val genres: List<Genre>,
    val platforms: List<Platform>,
    val description: String? = null,
    val developers: List<String> = emptyList()
)

package com.esgi_4al1_grp_9.backlogs.data.local

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.esgi_4al1_grp_9.backlogs.data.local.entities.DeveloperEntity
import com.esgi_4al1_grp_9.backlogs.data.local.entities.GameDeveloperEntity
import com.esgi_4al1_grp_9.backlogs.data.local.entities.GameEntity
import com.esgi_4al1_grp_9.backlogs.data.local.entities.GameGenreEntity
import com.esgi_4al1_grp_9.backlogs.data.local.entities.GamePlatformEntity
import com.esgi_4al1_grp_9.backlogs.data.local.entities.GenreEntity
import com.esgi_4al1_grp_9.backlogs.data.local.entities.PlatformEntity
import com.esgi_4al1_grp_9.backlogs.domain.model.Game
import java.time.LocalDate


/**
 * Query results, not tables. DAO methods returning these need @Transaction.
 */
data class GameWithRelations(
    @Embedded val game: GameEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = GameGenreEntity::class,
            parentColumn = "gameId",
            entityColumn = "genreId"
        )
    )
    val genres: List<GenreEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = GamePlatformEntity::class,
            parentColumn = "gameId",
            entityColumn = "platformId"
        )
    )
    val platforms: List<PlatformEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = GameDeveloperEntity::class,
            parentColumn = "gameId",
            entityColumn = "developerId"
        )
    )
    val developers: List<DeveloperEntity>
) {
    fun toDomain(): Game = Game(
        id = game.id,
        name = game.name,
        imageUrl = game.imageUrl,
        releaseDate = game.releaseDate?.let { LocalDate.ofEpochDay(it) },
        tba = game.tba,
        rating = game.rating,
        ratingsCount = game.ratingsCount,
        metacriticScore = game.metacriticScore,
        genres = genres.map { it.toDomain() },
        platforms = platforms.map { it.toDomain() },
        description = game.description,
        developers = developers.map { it.toDomain() }
    )
    // we only get the game list
}
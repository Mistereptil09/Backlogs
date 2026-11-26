package com.esgi_4al1_grp_9.backlogs.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

/** Many-to-many link between games and genres. */
@Entity(
    tableName = "game_genre",
    primaryKeys = ["gameId", "genreId"],
    foreignKeys = [
        ForeignKey(
            entity = GameEntity::class,
            parentColumns = ["id"],
            childColumns = ["gameId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = GenreEntity::class,
            parentColumns = ["id"],
            childColumns = ["genreId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("genreId")]
)
data class GameGenreEntity(
    val gameId: Int,
    val genreId: Int
)
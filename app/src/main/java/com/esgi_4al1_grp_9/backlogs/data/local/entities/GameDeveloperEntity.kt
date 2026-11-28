package com.esgi_4al1_grp_9.backlogs.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "game_developer",
    primaryKeys = ["gameId", "developerId"],
    foreignKeys = [
        ForeignKey(
            entity = GameEntity::class,
            parentColumns = ["id"],
            childColumns = ["gameId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = DeveloperEntity::class, parentColumns = ["id"], childColumns = ["developerId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("developerId")]
)
data class GameDeveloperEntity(val gameId: Int, val developerId: Int)
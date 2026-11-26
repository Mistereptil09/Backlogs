package com.esgi_4al1_grp_9.backlogs.data.local.entities


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.esgi_4al1_grp_9.backlogs.domain.model.BacklogEntry
import com.esgi_4al1_grp_9.backlogs.domain.model.GameStatus
import java.time.LocalDate


@Entity(
    tableName = "backlog_entries",
    foreignKeys = [
        ForeignKey(
            entity = GameEntity::class,
            parentColumns = ["id"],
            childColumns = ["gameId"],
            onDelete = ForeignKey.RESTRICT
        )
    ]
)
data class BacklogEntryEntity(
    @PrimaryKey val gameId: Int,
    val status: String,              // GameStatus.name
    val personalRating: Int?,
    val comment: String?,
    val addedAt: Long,               // epoch day
    val finishedAt: Long?            // epoch day
) {
    fun toDomain(): BacklogEntry = BacklogEntry(
        gameId = gameId,
        status = GameStatus.valueOf(status),
        personalRating = personalRating,
        comment = comment,
        addedAt = LocalDate.ofEpochDay(addedAt),
        finishedAt = finishedAt?.let { LocalDate.ofEpochDay(it) }
    )

    companion object {
        fun fromDomain(entry: BacklogEntry) = BacklogEntryEntity(
            gameId = entry.gameId,
            status = entry.status.name,
            personalRating = entry.personalRating,
            comment = entry.comment,
            addedAt = entry.addedAt.toEpochDay(),
            finishedAt = entry.finishedAt?.toEpochDay()
        )
    }
}
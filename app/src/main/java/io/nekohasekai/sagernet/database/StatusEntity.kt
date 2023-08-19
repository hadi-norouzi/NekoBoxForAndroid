package io.nekohasekai.sagernet.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(tableName = "status_entities")
data class StatusEntity(
    val status: Int = 0,
    val networkName: String = ""
)



data class ProxyEntityWithStatus(
    @Embedded val proxy: ProxyEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "status_entities"
    ) val statuses: List<StatusEntity>
)

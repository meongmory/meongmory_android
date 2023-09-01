package com.meongmoryteam.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meongmoryteam.data.local.model.DocumentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDocumentDao {
    @Query("SELECT * FROM documententity")
    fun getAll(): Flow<List<DocumentEntity>>

    @Query("SELECT * FROM documententity WHERE id = :id")
    fun get(id: String): Flow<DocumentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(documentEntity: DocumentEntity)

    @Delete
    suspend fun delete(documentEntity: DocumentEntity)
}
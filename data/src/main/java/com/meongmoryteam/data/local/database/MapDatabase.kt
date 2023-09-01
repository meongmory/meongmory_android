package com.meongmoryteam.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meongmoryteam.data.local.dao.FavoriteDocumentDao
import com.meongmoryteam.data.local.model.DocumentEntity

@Database(entities = [DocumentEntity::class], version = 1)
abstract class MapDatabase: RoomDatabase() {
    abstract fun favoriteDocumentDao(): FavoriteDocumentDao
}
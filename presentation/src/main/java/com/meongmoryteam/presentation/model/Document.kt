package com.meongmoryteam.presentation.model

import com.meongmoryteam.data.local.model.DocumentEntity
import com.meongmoryteam.data.remote.model.DocumentResult
import net.daum.mf.map.api.MapPOIItem
import java.util.Random

data class Document(
    val id: String,
    val placeName: String,
    private val categoryName: String,
    val roadAddressName: String,
    private val x: String,
    private val y: String,
    val rate: Float,
    var isFavorite: Boolean,
    var isSelected: Boolean = false,
    var mapPOIItem: MapPOIItem? = null
) {
    fun category(): String {
        val category = categoryName.split(">".toRegex()).dropLastWhile {
            it.isEmpty()
        }.toTypedArray().lastOrNull()
        return category ?: categoryName
    }

    fun x() = x.toDouble()
    fun y() = y.toDouble()

    fun toEntity(): DocumentEntity {
        return DocumentEntity(
            id,
            placeName,
            categoryName,
            roadAddressName,
            x,
            y,
            rate
        )
    }

    companion object {
        fun fromDocumentEntity(entity: DocumentEntity): Document {
            return Document(
                entity.id,
                entity.placeName,
                entity.categoryName,
                entity.roadAddressName,
                entity.x,
                entity.y,
                entity.rate,
                true
            )
        }

        fun fromDocumentResult(result: DocumentResult): Document {
            return Document(
                result.id,
                result.placeName,
                result.categoryName,
                result.roadAddressName,
                result.x,
                result.y,
                Random().nextFloat() * 5,
                false
            )
        }
    }

}
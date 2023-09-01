package com.meongmoryteam.presentation.model

import net.daum.mf.map.api.MapPOIItem

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

}
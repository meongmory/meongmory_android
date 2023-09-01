package com.meongmoryteam.presentation.ui.map.entity

enum class ListMode {
    LIST, MAP;

    val isList: Boolean
        get() = this == LIST
}
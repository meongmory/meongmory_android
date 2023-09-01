package com.meongmoryteam.presentation.ui.map.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(val latitude: Double, val longitude: Double): Parcelable

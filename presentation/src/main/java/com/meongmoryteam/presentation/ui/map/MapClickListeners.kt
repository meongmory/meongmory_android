package com.meongmoryteam.presentation.ui.map

import android.graphics.PointF
import android.location.Location
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.Symbol
import com.naver.maps.map.indoor.IndoorSelection

internal class MapClickListeners {
    var onMapClick: (PointF, LatLng) -> Unit by mutableStateOf({ _, _ -> })
    var onMapLongClick: (PointF, LatLng) -> Unit by mutableStateOf({ _, _ -> })
    var onMapDoubleTab: (point: PointF, coord: LatLng) -> Boolean by mutableStateOf({ _, _ -> false })
    var onMapTwoFingerTap: (point: PointF, coord: LatLng) -> Boolean by mutableStateOf({ _, _ -> false })
    var onMapLoaded: () -> Unit by mutableStateOf({})
    var onLocationChange: (Location) -> Unit by mutableStateOf({})
    var onOptionChange: () -> Unit by mutableStateOf({ })
    var onSymbolClick: (Symbol) -> Boolean by mutableStateOf({ false })
    var onIndoorSelectionChange: (IndoorSelection?) -> Unit by mutableStateOf({})
}

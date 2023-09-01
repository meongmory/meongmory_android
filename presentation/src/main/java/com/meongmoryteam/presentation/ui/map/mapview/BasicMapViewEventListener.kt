package com.meongmoryteam.presentation.ui.map.mapview

import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

open class BasicMapViewEventListener: MapView.MapViewEventListener {
    override fun onMapViewInitialized(p0: MapView?) { }
    override fun onMapViewCenterPointMoved(p0: MapView?, p1: MapPoint?) { }
    override fun onMapViewZoomLevelChanged(p0: MapView?, p1: Int) { }
    override fun onMapViewSingleTapped(p0: MapView?, p1: MapPoint?) { }
    override fun onMapViewDoubleTapped(p0: MapView?, p1: MapPoint?) { }
    override fun onMapViewLongPressed(p0: MapView?, p1: MapPoint?) { }
    override fun onMapViewDragStarted(p0: MapView?, p1: MapPoint?) { }
    override fun onMapViewDragEnded(p0: MapView?, p1: MapPoint?) { }
    override fun onMapViewMoveFinished(p0: MapView?, p1: MapPoint?) { }
}
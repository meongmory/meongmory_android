package com.meongmoryteam.presentation.ui.map

import androidx.compose.runtime.AbstractApplier
import com.naver.maps.map.NaverMap
import com.naver.maps.map.overlay.ArrowheadPathOverlay
import com.naver.maps.map.overlay.CircleOverlay
import com.naver.maps.map.overlay.GroundOverlay
import com.naver.maps.map.overlay.LocationOverlay
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.MultipartPathOverlay
import com.naver.maps.map.overlay.PathOverlay
import com.naver.maps.map.overlay.PolygonOverlay
import com.naver.maps.map.overlay.PolylineOverlay

internal interface MapNode {
    fun onAttached() {}
    fun onRemoved() {}
    fun onCleared() {}
}

private object MapNodeRoot : MapNode

internal class MapApplier(
    val map: NaverMap,
) : AbstractApplier<MapNode>(MapNodeRoot) {

    private val decorations = mutableListOf<MapNode>()

    override fun onClear() {
        decorations.forEach { it.onCleared() }
        decorations.clear()
    }

    override fun insertBottomUp(index: Int, instance: MapNode) {
        decorations.add(index, instance)
        instance.onAttached()
    }

    override fun insertTopDown(index: Int, instance: MapNode) {
        // insertBottomUp is preferred
    }

    override fun move(from: Int, to: Int, count: Int) {
        decorations.move(from, to, count)
    }

    override fun remove(index: Int, count: Int) {
        repeat(count) {
            decorations[index + it].onRemoved()
        }
        decorations.remove(index, count)
    }

    internal fun nodeForCircleOverlay(
        circleOverlay: CircleOverlay,
    ): CircleOverlayNode? {
        return decorations.firstOrNull {
            it is CircleOverlayNode && it.overlay == circleOverlay
        } as? CircleOverlayNode
    }

    internal fun nodeForPolygonOverlay(
        polygonOverlay: PolygonOverlay,
    ): PolygonOverlayNode? {
        return decorations.firstOrNull {
            it is PolygonOverlayNode && it.overlay == polygonOverlay
        } as? PolygonOverlayNode
    }

    internal fun nodeForPolylineOverlay(
        polylineOverlay: PolylineOverlay,
    ): PolylineOverlayNode? {
        return decorations.firstOrNull {
            it is PolylineOverlayNode && it.overlay == polylineOverlay
        } as? PolylineOverlayNode
    }

    internal fun nodeForPathOverlay(
        pathOverlay: PathOverlay,
    ): PathOverlayNode? {
        return decorations.firstOrNull {
            it is PathOverlayNode && it.overlay == pathOverlay
        } as? PathOverlayNode
    }

    internal fun nodeForMultipartPathOverlay(
        multipartPathOverlay: MultipartPathOverlay,
    ): MultipartPathOverlayNode? {
        return decorations.firstOrNull {
            it is MultipartPathOverlayNode && it.overlay == multipartPathOverlay
        } as? MultipartPathOverlayNode
    }

    internal fun nodeForArrowheadPathOverlay(
        arrowheadPathOverlay: ArrowheadPathOverlay,
    ): ArrowheadPathOverlayNode? {
        return decorations.firstOrNull {
            it is ArrowheadPathOverlayNode && it.overlay == arrowheadPathOverlay
        } as? ArrowheadPathOverlayNode
    }

    internal fun nodeForGroundOverlay(
        groundOverlay: GroundOverlay,
    ): GroundOverlayNode? {
        return decorations.firstOrNull {
            it is GroundOverlayNode && it.overlay == groundOverlay
        } as? GroundOverlayNode
    }

    internal fun nodeForMarker(
        marker: Marker,
    ): MarkerNode? {
        return decorations.firstOrNull {
            it is MarkerNode && it.overlay == marker
        } as? MarkerNode
    }

    internal fun nodeForLocationOverlay(
        locationOverlay: LocationOverlay,
    ): LocationOverlayNode? {
        return decorations.firstOrNull {
            it is LocationOverlayNode && it.overlay == locationOverlay
        } as? LocationOverlayNode
    }
}

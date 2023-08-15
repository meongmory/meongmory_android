/*
 * Copyright 2022 SOUP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.meongmoryteam.presentation.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Destination(val route: String) {
    Home("Home"),

    // BASIC
    Map("Map"),
    MapInColumn("MapInColumn"),
    MapClustering("MapClustering"),

    // OVERLAY
    Marker("Marker"),
    PolygonOverlay("PolygonOverlay"),
    PolylineOverlay("PolylineOverlay"),
    CircleOverlay("CircleOverlay"),
    LocationOverlay("LocationOverlay"),
    GroundOverlay("GroundOverlay"),
    PathOverlay("PathOverlay"),
    MultipartPathOverlay("MultipartPathOverlay"),
    ArrowheadPathOverlay("ArrowheadPathOverlay"),
    OverlayMinMaxZoom("OverlayMinMaxZoom"),
    GlobalZIndex("GlobalZIndex"),
    OverlayCollision("OverlayCollision"),

    // CAMERA
    CameraMove("CameraMove"),
    CameraAnimation("CameraAnimation"),
    CameraUpdateParams("CameraUpdateParams"),
    FitBounds("FitBounds"),
    Pivot("Pivot"),
    CameraEvent("CameraEvent"),

    // MAP
    MapTypesAndLayerGroups("MapTypesAndLayerGroups"),
    DisplayOptions("DisplayOptions"),
    IndoorMap("IndoorMap"),
    LiteMode("LiteMode"),
    NightMode("NightMode"),
    Locale("Locale"),

    // MAP OPTIONS
    MinMaxZoom("MinMaxZoom"),
    MaxTilt("MaxTilt"),
    Extent("Extent"),
    ContentPadding("ContentPadding"),
    ControlSettings("ControlSettings"),
    GestureSettings("GestureSettings"),

    // MAP EVENT
    MapClickEvent("MapClickEvent"),
    OverlayClickEvent("OverlayClickEvent"),
    SymbolClickEvent("SymbolClickEvent"),
    ZoomGesturesEvent("ZoomGesturesEvent"),

    // LOCATION
    LocationTracking("LocationTracking"),
    CustomLocationSource("CustomLocationSource"),
}

@Composable
fun NavGraph(
    startDestination: String = Destination.Home.route,
) {
    val navController = rememberNavController()
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Destination.Home.route) {
            HomeScreen(
                onItemClick = {
                    navController.navigate(route = it.route)
                }
            )
        }
    }
}

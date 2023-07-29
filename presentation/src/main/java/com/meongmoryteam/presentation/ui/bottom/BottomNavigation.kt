package com.meongmoryteam.presentation.ui.bottom

import androidx.annotation.DrawableRes
import com.meongmoryteam.presentation.R

enum class BottomNavigation(
    val route: String,
    @DrawableRes val icon: Int,
) {
    MAP(
        route = MeongMoryRoute.MAP.route,
        icon = R.drawable.map,
    ),
    HOME(
        route = MeongMoryRoute.HOME.route,
        icon = R.drawable.home,
    ),
    MY_PAGE(
        route = MeongMoryRoute.MY_PAGE.route,
        icon = R.drawable.user,
    )
}

enum class MeongMoryRoute(val route: String) {
    MAP("map"),
    HOME("home"),
    MY_PAGE("my-page"),
}
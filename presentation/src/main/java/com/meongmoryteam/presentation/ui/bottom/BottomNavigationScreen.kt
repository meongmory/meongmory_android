package com.meongmoryteam.presentation.ui.bottom

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.meongmoryteam.presentation.ui.theme.GRAY100
import com.meongmoryteam.presentation.ui.theme.MAIN100

@Composable
fun MeongMoryBottomNavigation(
    currentDestination: NavDestination?,
    navigateToScreen: (BottomNavigation) -> Unit,
) {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(
                width = 1.dp,
                color = GRAY100
            ),
    ) {
        BottomNavigation.values().forEach { bottomItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(bottomItem.icon),
                        contentDescription = bottomItem.route,
                        tint = if (currentDestination?.route == bottomItem.route) {
                            MAIN100
                        } else {
                            GRAY100
                        }
                    )
                },
                selected = currentDestination?.route == bottomItem.route,
                onClick = { navigateToScreen(bottomItem) },
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White),
            )
        }
    }
}

fun navigateBottomNavigationScreen(
    navController: NavHostController,
    navigationItem: BottomNavigation,
) {
    navController.navigate(navigationItem.route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Preview
@Composable
fun PreviewMeongMoryBottomNavigation() {
    MeongMoryBottomNavigation(
        currentDestination = null,
        navigateToScreen = {}
    )
}
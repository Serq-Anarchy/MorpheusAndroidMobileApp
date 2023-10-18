package ru.sedooj.morpheus.navigation.design

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.sedooj.morpheus.navigation.Screens

@Composable
fun BottomNavBar(
    navController: NavController,
) {
    val pageList = listOf(
        BottomNavBarItem.MAIN_PAGE,
        BottomNavBarItem.ACCOUNT_PAGE,
    )
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        pageList.forEach { page ->
            NavigationBarItem(
                selected = currentRoute == page.route,
                onClick = {
                    if (currentRoute != page.route) {
                        navController.navigate(route = page.route)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(page.icon),
                        contentDescription = page.title,
                        modifier = Modifier.size(25.dp)
                    )
                },
                label = {
                    Text(text = page.title, color = MaterialTheme.colorScheme.onBackground)
                }
            )
        }
    }
}

sealed class BottomNavBarItem(
    val title: String,
    val icon: Int,
    val route: String
) {
    object MAIN_PAGE :
        BottomNavBarItem(
            title = Screens.MAIN_PAGE.pageName,
            icon = Screens.MAIN_PAGE.icon,
            route = Screens.MAIN_PAGE.route
        )
    object ACCOUNT_PAGE :
        BottomNavBarItem(
            title = Screens.ACCOUNT_PAGE.pageName,
            icon = Screens.ACCOUNT_PAGE.icon,
            route = Screens.ACCOUNT_PAGE.route
        )
}
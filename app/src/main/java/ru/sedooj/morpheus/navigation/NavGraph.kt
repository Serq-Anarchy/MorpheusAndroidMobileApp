package ru.sedooj.morpheus.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.sedooj.morpheus.pages.account.AccountPage
import ru.sedooj.morpheus.pages.main.MainPage

@Composable
fun SetupNavigation(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screens.MAIN_PAGE.route,
        exitTransition = {
            fadeOut(tween(0))
        },
        enterTransition = {
            fadeIn(tween(0))
        },
        popEnterTransition = {
            fadeIn(tween(0))
        },
        popExitTransition = {
            fadeOut(tween(0))
        }
    ) {
        composable(
            route = Screens.MAIN_PAGE.route
        ) {
            MainPage(padding = padding)
        }

        composable(
            route = Screens.ACCOUNT_PAGE.route
        ) {
            AccountPage(padding = padding)
        }

    }
}
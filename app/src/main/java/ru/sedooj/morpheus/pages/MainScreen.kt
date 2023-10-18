package ru.sedooj.morpheus.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.sedooj.morpheus.navigation.SetupNavigation
import ru.sedooj.morpheus.navigation.design.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController
            )
        },
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            SetupNavigation(navController = navController, padding = padding)
        }
    )
}
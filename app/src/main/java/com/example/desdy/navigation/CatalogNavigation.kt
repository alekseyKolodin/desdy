package com.example.desdy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.desdy.screens.ButtonsScreen
import com.example.desdy.screens.CardsScreen
import com.example.desdy.screens.ChipsScreen
import com.example.desdy.screens.ColorsScreen
import com.example.desdy.screens.DialogsScreen
import com.example.desdy.screens.HomeScreen
import com.example.desdy.screens.InputsScreen
import com.example.desdy.screens.ProgressScreen
import com.example.desdy.screens.SelectionScreen
import com.example.desdy.screens.TypographyScreen

/**
 * Navigation routes for the catalog app.
 */
sealed class CatalogRoute(val route: String) {
    data object Home : CatalogRoute("home")
    data object Colors : CatalogRoute("colors")
    data object Typography : CatalogRoute("typography")
    data object Buttons : CatalogRoute("buttons")
    data object Inputs : CatalogRoute("inputs")
    data object Selection : CatalogRoute("selection")
    data object Cards : CatalogRoute("cards")
    data object Chips : CatalogRoute("chips")
    data object Progress : CatalogRoute("progress")
    data object Dialogs : CatalogRoute("dialogs")
}

/**
 * Navigation host for the catalog app.
 */
@Composable
fun CatalogNavHost(
    navController: NavHostController,
    onThemeToggle: () -> Unit,
    isDarkTheme: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = CatalogRoute.Home.route
    ) {
        composable(CatalogRoute.Home.route) {
            HomeScreen(
                onNavigate = { route -> navController.navigate(route) },
                onThemeToggle = onThemeToggle,
                isDarkTheme = isDarkTheme
            )
        }
        composable(CatalogRoute.Colors.route) {
            ColorsScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Typography.route) {
            TypographyScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Buttons.route) {
            ButtonsScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Inputs.route) {
            InputsScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Selection.route) {
            SelectionScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Cards.route) {
            CardsScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Chips.route) {
            ChipsScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Progress.route) {
            ProgressScreen(onBack = { navController.popBackStack() })
        }
        composable(CatalogRoute.Dialogs.route) {
            DialogsScreen(onBack = { navController.popBackStack() })
        }
    }
}

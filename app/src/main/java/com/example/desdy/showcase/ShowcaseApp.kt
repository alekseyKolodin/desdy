package com.example.desdy.showcase

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.desdy.components.navigation.DesdyNavigationBar
import com.desdy.components.navigation.DesdyNavigationBarItem
import com.desdy.theme.DesdyTheme
import com.example.desdy.showcase.screens.ComponentsScreen
import com.example.desdy.showcase.screens.ExamplesScreen
import com.example.desdy.showcase.screens.FoundationScreen
import com.example.desdy.showcase.screens.ShowcaseSettingsScreen

/**
 * Main Showcase Application with Bottom Navigation.
 * Demonstrates all Desdy Design System components.
 */
@Composable
fun DesdyShowcaseApp(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    DesdyTheme(darkTheme = isDarkTheme) {
        Scaffold(
            containerColor = DesdyTheme.colors.background,
            bottomBar = {
                DesdyNavigationBar {
                    DesdyNavigationBarItem(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        icon = { Icon(Icons.Default.Widgets, contentDescription = null) },
                        label = { Text("Компоненты") }
                    )
                    DesdyNavigationBarItem(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        icon = { Icon(Icons.Default.Palette, contentDescription = null) },
                        label = { Text("Фундамент") }
                    )
                    DesdyNavigationBarItem(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        icon = { Icon(Icons.Default.PhoneAndroid, contentDescription = null) },
                        label = { Text("Примеры") }
                    )
                    DesdyNavigationBarItem(
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 },
                        icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                        label = { Text("Настройки") }
                    )
                }
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                when (selectedTab) {
                    0 -> ComponentsScreen()
                    1 -> FoundationScreen()
                    2 -> ExamplesScreen()
                    3 -> ShowcaseSettingsScreen(
                        isDarkTheme = isDarkTheme,
                        onThemeChange = onThemeChange
                    )
                }
            }
        }
    }
}

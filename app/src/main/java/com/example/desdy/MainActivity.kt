package com.example.desdy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.desdy.theme.DesdyTheme
import com.example.desdy.navigation.CatalogNavHost

/**
 * Main activity for the Desdy Design System catalog app.
 *
 * Showcases all components in the design system with theme switching.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            val navController = rememberNavController()

            DesdyTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DesdyTheme.colors.background
                ) {
                    CatalogNavHost(
                        navController = navController,
                        onThemeToggle = { isDarkTheme = !isDarkTheme },
                        isDarkTheme = isDarkTheme
                    )
                }
            }
        }
    }
}

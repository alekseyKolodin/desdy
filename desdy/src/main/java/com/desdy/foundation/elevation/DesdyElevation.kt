package com.desdy.foundation.elevation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Elevation system for Desdy Design System.
 * Based on Material 3 elevation scale.
 */
@Immutable
data class DesdyElevation(
    /** 0dp - Flat surface, no elevation */
    val level0: Dp,

    /** 1dp - Subtle lift (e.g., cards at rest) */
    val level1: Dp,

    /** 3dp - Slight elevation (e.g., elevated cards) */
    val level2: Dp,

    /** 6dp - Medium elevation (e.g., navigation bars) */
    val level3: Dp,

    /** 8dp - Higher elevation (e.g., menus) */
    val level4: Dp,

    /** 12dp - High elevation (e.g., dialogs, modal sheets) */
    val level5: Dp
)

/**
 * Default elevation values for Desdy Design System.
 * Matches Material 3 elevation levels.
 */
val DesdyElevationDefaults = DesdyElevation(
    level0 = 0.dp,
    level1 = 1.dp,
    level2 = 3.dp,
    level3 = 6.dp,
    level4 = 8.dp,
    level5 = 12.dp
)

/**
 * CompositionLocal for DesdyElevation.
 */
val LocalDesdyElevation = staticCompositionLocalOf { DesdyElevationDefaults }

/**
 * Helper object with named elevation presets for common components.
 */
object DesdyElevationTokens {
    /** Elevation for cards at rest */
    val Card = DesdyElevationDefaults.level1

    /** Elevation for elevated/raised cards */
    val CardElevated = DesdyElevationDefaults.level2

    /** Elevation for navigation components */
    val Navigation = DesdyElevationDefaults.level3

    /** Elevation for menus and dropdowns */
    val Menu = DesdyElevationDefaults.level4

    /** Elevation for dialogs and modal sheets */
    val Dialog = DesdyElevationDefaults.level5

    /** Elevation for FAB */
    val Fab = DesdyElevationDefaults.level3

    /** Elevation for snackbars */
    val Snackbar = DesdyElevationDefaults.level3
}

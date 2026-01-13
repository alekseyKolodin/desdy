package com.desdy.foundation.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Semantic color system for Desdy Design System.
 * Maps color primitives to meaningful roles.
 */
@Immutable
data class DesdyColors(
    // Primary colors
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,

    // Secondary colors
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,

    // Tertiary colors
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,

    // Background and surface
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val surfaceTint: Color,
    val surfaceContainerLowest: Color,
    val surfaceContainerLow: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceContainerHighest: Color,

    // Inverse colors
    val inverseSurface: Color,
    val inverseOnSurface: Color,
    val inversePrimary: Color,

    // Outline colors
    val outline: Color,
    val outlineVariant: Color,

    // Semantic status colors
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,

    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,

    val warning: Color,
    val onWarning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,

    val info: Color,
    val onInfo: Color,
    val infoContainer: Color,
    val onInfoContainer: Color,

    // Special
    val scrim: Color,
    val disabled: Color,
    val onDisabled: Color,
    val divider: Color
)

/**
 * CompositionLocal for DesdyColors.
 * Provides color access throughout the composition tree.
 */
val LocalDesdyColors = staticCompositionLocalOf { DesdyLightColors }

package com.desdy.foundation.spacing

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Spacing system for Desdy Design System.
 * Based on 4dp grid for consistent rhythm.
 */
@Immutable
data class DesdySpacing(
    /** 0dp - No spacing */
    val none: Dp,

    /** 2dp - Hairline spacing */
    val hairline: Dp,

    /** 4dp - Extra small spacing */
    val extraSmall: Dp,

    /** 8dp - Small spacing */
    val small: Dp,

    /** 12dp - Medium-small spacing */
    val mediumSmall: Dp,

    /** 16dp - Medium spacing */
    val medium: Dp,

    /** 20dp - Medium-large spacing */
    val mediumLarge: Dp,

    /** 24dp - Large spacing */
    val large: Dp,

    /** 32dp - Extra large spacing */
    val extraLarge: Dp,

    /** 40dp - Huge spacing */
    val huge: Dp,

    /** 48dp - Extra huge spacing */
    val extraHuge: Dp,

    /** 64dp - Massive spacing */
    val massive: Dp
)

/**
 * Default spacing values for Desdy Design System.
 * All values are multiples of 4dp base unit.
 */
val DesdySpacingDefaults = DesdySpacing(
    none = 0.dp,
    hairline = 2.dp,
    extraSmall = 4.dp,
    small = 8.dp,
    mediumSmall = 12.dp,
    medium = 16.dp,
    mediumLarge = 20.dp,
    large = 24.dp,
    extraLarge = 32.dp,
    huge = 40.dp,
    extraHuge = 48.dp,
    massive = 64.dp
)

/**
 * CompositionLocal for DesdySpacing.
 */
val LocalDesdySpacing = staticCompositionLocalOf { DesdySpacingDefaults }

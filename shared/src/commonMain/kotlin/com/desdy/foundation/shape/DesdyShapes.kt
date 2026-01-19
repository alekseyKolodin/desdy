package com.desdy.foundation.shape

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

/**
 * Shape system for Desdy Design System.
 * Uses rounded corners for elegant, noble aesthetic.
 */
@Immutable
data class DesdyShapes(
    /** 0dp - Sharp corners, no rounding */
    val none: CornerBasedShape,

    /** 4dp - Subtle rounding for small elements */
    val extraSmall: CornerBasedShape,

    /** 8dp - Buttons, chips, small cards */
    val small: CornerBasedShape,

    /** 12dp - Cards, dialogs */
    val medium: CornerBasedShape,

    /** 16dp - Bottom sheets, large cards */
    val large: CornerBasedShape,

    /** 28dp - Extra large surfaces */
    val extraLarge: CornerBasedShape,

    /** 50% - Pills, FABs, circular elements */
    val full: CornerBasedShape
)

/**
 * Default shape values for Desdy Design System.
 */
val DesdyShapesDefaults = DesdyShapes(
    none = RoundedCornerShape(0.dp),
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(28.dp),
    full = RoundedCornerShape(percent = 50)
)

/**
 * CompositionLocal for DesdyShapes.
 */
val LocalDesdyShapes = staticCompositionLocalOf { DesdyShapesDefaults }

/**
 * Convert DesdyShapes to Material 3 Shapes for interoperability.
 */
fun DesdyShapes.toMaterialShapes(): Shapes {
    return Shapes(
        extraSmall = extraSmall,
        small = small,
        medium = medium,
        large = large,
        extraLarge = extraLarge
    )
}

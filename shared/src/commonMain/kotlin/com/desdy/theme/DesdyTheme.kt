package com.desdy.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.desdy.foundation.color.DesdyColors
import com.desdy.foundation.color.DesdyDarkColors
import com.desdy.foundation.color.DesdyLightColors
import com.desdy.foundation.color.LocalDesdyColors
import com.desdy.foundation.color.toMaterialColorScheme
import com.desdy.foundation.elevation.DesdyElevation
import com.desdy.foundation.elevation.DesdyElevationDefaults
import com.desdy.foundation.elevation.LocalDesdyElevation
import com.desdy.foundation.shape.DesdyShapes
import com.desdy.foundation.shape.DesdyShapesDefaults
import com.desdy.foundation.shape.LocalDesdyShapes
import com.desdy.foundation.shape.toMaterialShapes
import com.desdy.foundation.spacing.DesdySpacing
import com.desdy.foundation.spacing.DesdySpacingDefaults
import com.desdy.foundation.spacing.LocalDesdySpacing
import com.desdy.foundation.typography.DesdyTypography
import com.desdy.foundation.typography.DesdyTypographyDefaults
import com.desdy.foundation.typography.LocalDesdyTypography
import com.desdy.foundation.typography.toMaterialTypography
import com.desdy.platform.isSystemInDarkTheme

/**
 * Desdy Design System Theme.
 *
 * Wraps content with Desdy design tokens and Material 3 theme for interoperability.
 *
 * @param darkTheme Whether to use dark theme. Defaults to true for SoulSync.
 * @param colors Custom color scheme. Defaults to Desdy dark/light colors.
 * @param typography Custom typography. Defaults to Desdy typography.
 * @param shapes Custom shapes. Defaults to Desdy shapes.
 * @param spacing Custom spacing. Defaults to Desdy spacing.
 * @param elevation Custom elevation. Defaults to Desdy elevation.
 * @param content The content to be themed.
 *
 * Usage:
 * ```kotlin
 * DesdyTheme {
 *     DesdyButton(
 *         text = "Hello",
 *         onClick = { }
 *     )
 * }
 * ```
 */
@Composable
fun DesdyTheme(
    darkTheme: Boolean = true, // Dark theme by default for SoulSync
    colors: DesdyColors = if (darkTheme) DesdyDarkColors else DesdyLightColors,
    typography: DesdyTypography = DesdyTypographyDefaults,
    shapes: DesdyShapes = DesdyShapesDefaults,
    spacing: DesdySpacing = DesdySpacingDefaults,
    elevation: DesdyElevation = DesdyElevationDefaults,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalDesdyColors provides colors,
        LocalDesdyTypography provides typography,
        LocalDesdyShapes provides shapes,
        LocalDesdySpacing provides spacing,
        LocalDesdyElevation provides elevation
    ) {
        // Wrap with MaterialTheme for Material 3 component interoperability
        MaterialTheme(
            colorScheme = colors.toMaterialColorScheme(),
            typography = typography.toMaterialTypography(),
            shapes = shapes.toMaterialShapes(),
            content = content
        )
    }
}

/**
 * Object for convenient access to Desdy design tokens.
 *
 * Usage:
 * ```kotlin
 * Text(
 *     text = "Hello",
 *     color = DesdyTheme.colors.primary,
 *     style = DesdyTheme.typography.bodyMedium
 * )
 * ```
 */
object DesdyTheme {

    /**
     * Current Desdy color scheme.
     */
    val colors: DesdyColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDesdyColors.current

    /**
     * Current Desdy typography.
     */
    val typography: DesdyTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDesdyTypography.current

    /**
     * Current Desdy shapes.
     */
    val shapes: DesdyShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalDesdyShapes.current

    /**
     * Current Desdy spacing.
     */
    val spacing: DesdySpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalDesdySpacing.current

    /**
     * Current Desdy elevation.
     */
    val elevation: DesdyElevation
        @Composable
        @ReadOnlyComposable
        get() = LocalDesdyElevation.current
}

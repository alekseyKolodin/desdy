package com.desdy.foundation.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Dark color scheme for Desdy Design System (SoulSync).
 * This is the PRIMARY theme for SoulSync - dark, intimate, elegant.
 */
val DesdyDarkColors = DesdyColors(
    // Primary - Teal (Trust, calm, intimacy)
    primary = DesdyColorPrimitives.Teal500,
    onPrimary = DesdyColorPrimitives.White,
    primaryContainer = DesdyColorPrimitives.Teal900,
    onPrimaryContainer = DesdyColorPrimitives.Teal100,

    // Secondary - Rose (Passion, warmth)
    secondary = DesdyColorPrimitives.Rose500,
    onSecondary = DesdyColorPrimitives.White,
    secondaryContainer = DesdyColorPrimitives.Rose900,
    onSecondaryContainer = DesdyColorPrimitives.Rose100,

    // Tertiary - Success Green
    tertiary = DesdyColorPrimitives.Success400,
    onTertiary = DesdyColorPrimitives.Success900,
    tertiaryContainer = DesdyColorPrimitives.Success900,
    onTertiaryContainer = DesdyColorPrimitives.Success100,

    // Background and Surface - Dark Slate for intimate mood
    background = DesdyColorPrimitives.Slate900,       // #0f172a
    onBackground = DesdyColorPrimitives.Slate100,     // #f1f5f9
    surface = DesdyColorPrimitives.Slate800,          // #1e293b
    onSurface = DesdyColorPrimitives.Slate100,        // #f1f5f9
    surfaceVariant = DesdyColorPrimitives.Slate700,
    onSurfaceVariant = DesdyColorPrimitives.Slate300, // #cbd5e1 muted
    surfaceTint = DesdyColorPrimitives.Teal500,
    surfaceContainerLowest = DesdyColorPrimitives.Slate950,
    surfaceContainerLow = DesdyColorPrimitives.Slate900,
    surfaceContainer = DesdyColorPrimitives.Slate800,
    surfaceContainerHigh = DesdyColorPrimitives.Slate700,
    surfaceContainerHighest = DesdyColorPrimitives.Slate600,

    // Inverse
    inverseSurface = DesdyColorPrimitives.Slate100,
    inverseOnSurface = DesdyColorPrimitives.Slate800,
    inversePrimary = DesdyColorPrimitives.Teal700,

    // Outline
    outline = DesdyColorPrimitives.Slate600,
    outlineVariant = DesdyColorPrimitives.Slate700,

    // Semantic - Error
    error = DesdyColorPrimitives.Error400,
    onError = DesdyColorPrimitives.Error900,
    errorContainer = DesdyColorPrimitives.Error900,
    onErrorContainer = DesdyColorPrimitives.Error100,

    // Semantic - Success
    success = DesdyColorPrimitives.Success400,
    onSuccess = DesdyColorPrimitives.Success900,
    successContainer = DesdyColorPrimitives.Success900,
    onSuccessContainer = DesdyColorPrimitives.Success100,

    // Semantic - Warning
    warning = DesdyColorPrimitives.Warning400,
    onWarning = DesdyColorPrimitives.Warning900,
    warningContainer = DesdyColorPrimitives.Warning900,
    onWarningContainer = DesdyColorPrimitives.Warning100,

    // Semantic - Info
    info = DesdyColorPrimitives.Info400,
    onInfo = DesdyColorPrimitives.Info900,
    infoContainer = DesdyColorPrimitives.Info900,
    onInfoContainer = DesdyColorPrimitives.Info100,

    // Special
    scrim = DesdyColorPrimitives.Scrim,
    disabled = DesdyColorPrimitives.Slate500,
    onDisabled = DesdyColorPrimitives.Slate600,
    divider = DesdyColorPrimitives.Slate700
)

/**
 * Light color scheme for Desdy Design System.
 * Alternative theme for light mode preferences.
 */
val DesdyLightColors = DesdyColors(
    // Primary - Teal
    primary = DesdyColorPrimitives.Teal500,
    onPrimary = DesdyColorPrimitives.White,
    primaryContainer = DesdyColorPrimitives.Teal100,
    onPrimaryContainer = DesdyColorPrimitives.Teal900,

    // Secondary - Rose
    secondary = DesdyColorPrimitives.Rose500,
    onSecondary = DesdyColorPrimitives.White,
    secondaryContainer = DesdyColorPrimitives.Rose100,
    onSecondaryContainer = DesdyColorPrimitives.Rose900,

    // Tertiary - Success Green
    tertiary = DesdyColorPrimitives.Success500,
    onTertiary = DesdyColorPrimitives.White,
    tertiaryContainer = DesdyColorPrimitives.Success100,
    onTertiaryContainer = DesdyColorPrimitives.Success900,

    // Background and Surface - Light slate
    background = DesdyColorPrimitives.Slate50,
    onBackground = DesdyColorPrimitives.Slate900,
    surface = DesdyColorPrimitives.White,
    onSurface = DesdyColorPrimitives.Slate800,
    surfaceVariant = DesdyColorPrimitives.Slate100,
    onSurfaceVariant = DesdyColorPrimitives.Slate600,
    surfaceTint = DesdyColorPrimitives.Teal500,
    surfaceContainerLowest = DesdyColorPrimitives.White,
    surfaceContainerLow = DesdyColorPrimitives.Slate50,
    surfaceContainer = DesdyColorPrimitives.Slate100,
    surfaceContainerHigh = DesdyColorPrimitives.Slate200,
    surfaceContainerHighest = DesdyColorPrimitives.Slate300,

    // Inverse
    inverseSurface = DesdyColorPrimitives.Slate800,
    inverseOnSurface = DesdyColorPrimitives.Slate100,
    inversePrimary = DesdyColorPrimitives.Teal300,

    // Outline
    outline = DesdyColorPrimitives.Slate300,
    outlineVariant = DesdyColorPrimitives.Slate200,

    // Semantic - Error
    error = DesdyColorPrimitives.Error500,
    onError = DesdyColorPrimitives.White,
    errorContainer = DesdyColorPrimitives.Error100,
    onErrorContainer = DesdyColorPrimitives.Error900,

    // Semantic - Success
    success = DesdyColorPrimitives.Success500,
    onSuccess = DesdyColorPrimitives.White,
    successContainer = DesdyColorPrimitives.Success100,
    onSuccessContainer = DesdyColorPrimitives.Success900,

    // Semantic - Warning
    warning = DesdyColorPrimitives.Warning500,
    onWarning = DesdyColorPrimitives.White,
    warningContainer = DesdyColorPrimitives.Warning100,
    onWarningContainer = DesdyColorPrimitives.Warning900,

    // Semantic - Info
    info = DesdyColorPrimitives.Info500,
    onInfo = DesdyColorPrimitives.White,
    infoContainer = DesdyColorPrimitives.Info100,
    onInfoContainer = DesdyColorPrimitives.Info900,

    // Special
    scrim = Color(0x52000000),
    disabled = DesdyColorPrimitives.Slate400,
    onDisabled = DesdyColorPrimitives.Slate500,
    divider = DesdyColorPrimitives.Slate200
)

/**
 * Convert DesdyColors to Material 3 ColorScheme for interoperability.
 */
fun DesdyColors.toMaterialColorScheme(): ColorScheme {
    return if (this.background == DesdyColorPrimitives.Slate900) {
        darkColorScheme(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = onSurfaceVariant,
            surfaceTint = surfaceTint,
            inverseSurface = inverseSurface,
            inverseOnSurface = inverseOnSurface,
            inversePrimary = inversePrimary,
            outline = outline,
            outlineVariant = outlineVariant,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            scrim = scrim
        )
    } else {
        lightColorScheme(
            primary = primary,
            onPrimary = onPrimary,
            primaryContainer = primaryContainer,
            onPrimaryContainer = onPrimaryContainer,
            secondary = secondary,
            onSecondary = onSecondary,
            secondaryContainer = secondaryContainer,
            onSecondaryContainer = onSecondaryContainer,
            tertiary = tertiary,
            onTertiary = onTertiary,
            tertiaryContainer = tertiaryContainer,
            onTertiaryContainer = onTertiaryContainer,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = onSurfaceVariant,
            surfaceTint = surfaceTint,
            inverseSurface = inverseSurface,
            inverseOnSurface = inverseOnSurface,
            inversePrimary = inversePrimary,
            outline = outline,
            outlineVariant = outlineVariant,
            error = error,
            onError = onError,
            errorContainer = errorContainer,
            onErrorContainer = onErrorContainer,
            scrim = scrim
        )
    }
}

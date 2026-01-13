package com.desdy.foundation.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

/**
 * Light color scheme for Desdy Design System.
 * Uses dusty rose as primary, sage as secondary, slate as tertiary.
 */
val DesdyLightColors = DesdyColors(
    // Primary - Dusty Rose
    primary = DesdyColorPrimitives.Rose600,
    onPrimary = DesdyColorPrimitives.White,
    primaryContainer = DesdyColorPrimitives.Rose100,
    onPrimaryContainer = DesdyColorPrimitives.Rose900,

    // Secondary - Sage Green
    secondary = DesdyColorPrimitives.Sage600,
    onSecondary = DesdyColorPrimitives.White,
    secondaryContainer = DesdyColorPrimitives.Sage100,
    onSecondaryContainer = DesdyColorPrimitives.Sage900,

    // Tertiary - Slate Blue
    tertiary = DesdyColorPrimitives.Slate600,
    onTertiary = DesdyColorPrimitives.White,
    tertiaryContainer = DesdyColorPrimitives.Slate100,
    onTertiaryContainer = DesdyColorPrimitives.Slate900,

    // Background and Surface - Warm neutrals
    background = DesdyColorPrimitives.Neutral50,
    onBackground = DesdyColorPrimitives.Neutral900,
    surface = DesdyColorPrimitives.White,
    onSurface = DesdyColorPrimitives.Neutral900,
    surfaceVariant = DesdyColorPrimitives.Neutral100,
    onSurfaceVariant = DesdyColorPrimitives.Neutral700,
    surfaceTint = DesdyColorPrimitives.Rose600,
    surfaceContainerLowest = DesdyColorPrimitives.White,
    surfaceContainerLow = DesdyColorPrimitives.Neutral50,
    surfaceContainer = DesdyColorPrimitives.Neutral100,
    surfaceContainerHigh = DesdyColorPrimitives.Neutral200,
    surfaceContainerHighest = DesdyColorPrimitives.Neutral300,

    // Inverse
    inverseSurface = DesdyColorPrimitives.Neutral800,
    inverseOnSurface = DesdyColorPrimitives.Neutral100,
    inversePrimary = DesdyColorPrimitives.Rose200,

    // Outline
    outline = DesdyColorPrimitives.Neutral400,
    outlineVariant = DesdyColorPrimitives.Neutral200,

    // Error
    error = DesdyColorPrimitives.Error600,
    onError = DesdyColorPrimitives.White,
    errorContainer = DesdyColorPrimitives.Error100,
    onErrorContainer = DesdyColorPrimitives.Error900,

    // Success
    success = DesdyColorPrimitives.Success600,
    onSuccess = DesdyColorPrimitives.White,
    successContainer = DesdyColorPrimitives.Success100,
    onSuccessContainer = DesdyColorPrimitives.Success900,

    // Warning
    warning = DesdyColorPrimitives.Warning600,
    onWarning = DesdyColorPrimitives.White,
    warningContainer = DesdyColorPrimitives.Warning100,
    onWarningContainer = DesdyColorPrimitives.Warning900,

    // Info
    info = DesdyColorPrimitives.Info600,
    onInfo = DesdyColorPrimitives.White,
    infoContainer = DesdyColorPrimitives.Info100,
    onInfoContainer = DesdyColorPrimitives.Info900,

    // Special
    scrim = DesdyColorPrimitives.Scrim,
    disabled = DesdyColorPrimitives.Neutral300,
    onDisabled = DesdyColorPrimitives.Neutral500,
    divider = DesdyColorPrimitives.Neutral200
)

/**
 * Dark color scheme for Desdy Design System.
 * Inverted palette with softer contrasts for dark mode.
 */
val DesdyDarkColors = DesdyColors(
    // Primary - Dusty Rose (lighter for dark theme)
    primary = DesdyColorPrimitives.Rose300,
    onPrimary = DesdyColorPrimitives.Rose900,
    primaryContainer = DesdyColorPrimitives.Rose800,
    onPrimaryContainer = DesdyColorPrimitives.Rose100,

    // Secondary - Sage Green
    secondary = DesdyColorPrimitives.Sage300,
    onSecondary = DesdyColorPrimitives.Sage900,
    secondaryContainer = DesdyColorPrimitives.Sage800,
    onSecondaryContainer = DesdyColorPrimitives.Sage100,

    // Tertiary - Slate Blue
    tertiary = DesdyColorPrimitives.Slate300,
    onTertiary = DesdyColorPrimitives.Slate900,
    tertiaryContainer = DesdyColorPrimitives.Slate800,
    onTertiaryContainer = DesdyColorPrimitives.Slate100,

    // Background and Surface - Dark warm neutrals
    background = DesdyColorPrimitives.Neutral950,
    onBackground = DesdyColorPrimitives.Neutral100,
    surface = DesdyColorPrimitives.Neutral900,
    onSurface = DesdyColorPrimitives.Neutral100,
    surfaceVariant = DesdyColorPrimitives.Neutral800,
    onSurfaceVariant = DesdyColorPrimitives.Neutral300,
    surfaceTint = DesdyColorPrimitives.Rose300,
    surfaceContainerLowest = DesdyColorPrimitives.Neutral950,
    surfaceContainerLow = DesdyColorPrimitives.Neutral900,
    surfaceContainer = DesdyColorPrimitives.Neutral800,
    surfaceContainerHigh = DesdyColorPrimitives.Neutral700,
    surfaceContainerHighest = DesdyColorPrimitives.Neutral600,

    // Inverse
    inverseSurface = DesdyColorPrimitives.Neutral100,
    inverseOnSurface = DesdyColorPrimitives.Neutral800,
    inversePrimary = DesdyColorPrimitives.Rose600,

    // Outline
    outline = DesdyColorPrimitives.Neutral500,
    outlineVariant = DesdyColorPrimitives.Neutral700,

    // Error
    error = DesdyColorPrimitives.Error300,
    onError = DesdyColorPrimitives.Error900,
    errorContainer = DesdyColorPrimitives.Error800,
    onErrorContainer = DesdyColorPrimitives.Error100,

    // Success
    success = DesdyColorPrimitives.Success300,
    onSuccess = DesdyColorPrimitives.Success900,
    successContainer = DesdyColorPrimitives.Success800,
    onSuccessContainer = DesdyColorPrimitives.Success100,

    // Warning
    warning = DesdyColorPrimitives.Warning300,
    onWarning = DesdyColorPrimitives.Warning900,
    warningContainer = DesdyColorPrimitives.Warning800,
    onWarningContainer = DesdyColorPrimitives.Warning100,

    // Info
    info = DesdyColorPrimitives.Info300,
    onInfo = DesdyColorPrimitives.Info900,
    infoContainer = DesdyColorPrimitives.Info800,
    onInfoContainer = DesdyColorPrimitives.Info100,

    // Special
    scrim = DesdyColorPrimitives.Scrim,
    disabled = DesdyColorPrimitives.Neutral700,
    onDisabled = DesdyColorPrimitives.Neutral500,
    divider = DesdyColorPrimitives.Neutral700
)

/**
 * Convert DesdyColors to Material 3 ColorScheme for interoperability.
 */
fun DesdyColors.toMaterialColorScheme(): ColorScheme {
    return if (this == DesdyLightColors) {
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
    } else {
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
    }
}

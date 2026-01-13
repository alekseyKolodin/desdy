package com.desdy.foundation.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Light color scheme for Desdy Design System.
 * - Primary: Blue
 * - Secondary: Slate (neutral gray-blue)
 * - Tertiary: Emerald
 */
val DesdyLightColors = DesdyColors(
    // Primary - Blue
    primary = DesdyColorPrimitives.Blue500,
    onPrimary = DesdyColorPrimitives.White,
    primaryContainer = DesdyColorPrimitives.Blue100,
    onPrimaryContainer = DesdyColorPrimitives.Blue900,

    // Secondary - Slate (neutral gray-blue)
    secondary = DesdyColorPrimitives.Slate500,
    onSecondary = DesdyColorPrimitives.White,
    secondaryContainer = DesdyColorPrimitives.Slate100,
    onSecondaryContainer = DesdyColorPrimitives.Slate700,

    // Tertiary - Emerald
    tertiary = DesdyColorPrimitives.Emerald500,
    onTertiary = DesdyColorPrimitives.White,
    tertiaryContainer = DesdyColorPrimitives.Emerald100,
    onTertiaryContainer = DesdyColorPrimitives.Emerald900,

    // Background and Surface - Cool slate neutrals
    background = DesdyColorPrimitives.Slate50,
    onBackground = DesdyColorPrimitives.Slate900,
    surface = DesdyColorPrimitives.White,
    onSurface = DesdyColorPrimitives.Slate800,
    surfaceVariant = DesdyColorPrimitives.Slate100,
    onSurfaceVariant = DesdyColorPrimitives.Slate600,
    surfaceTint = DesdyColorPrimitives.Blue500,
    surfaceContainerLowest = DesdyColorPrimitives.White,
    surfaceContainerLow = DesdyColorPrimitives.Slate50,
    surfaceContainer = DesdyColorPrimitives.Slate200,
    surfaceContainerHigh = DesdyColorPrimitives.Slate200,
    surfaceContainerHighest = DesdyColorPrimitives.Slate300,

    // Inverse
    inverseSurface = DesdyColorPrimitives.Slate800,
    inverseOnSurface = DesdyColorPrimitives.Slate100,
    inversePrimary = DesdyColorPrimitives.Blue200,

    // Outline
    outline = DesdyColorPrimitives.Slate300,
    outlineVariant = DesdyColorPrimitives.Slate200,

    // Error - Tailwind Red
    error = Color(0xFFEF4444),
    onError = DesdyColorPrimitives.White,
    errorContainer = Color(0xFFFEE2E2),
    onErrorContainer = Color(0xFF991B1B),

    // Success - Tailwind Green
    success = Color(0xFF22C55E),
    onSuccess = DesdyColorPrimitives.White,
    successContainer = Color(0xFFDCFCE7),
    onSuccessContainer = Color(0xFF166534),

    // Warning - Tailwind Amber
    warning = Color(0xFFF59E0B),
    onWarning = DesdyColorPrimitives.White,
    warningContainer = Color(0xFFFEF3C7),
    onWarningContainer = Color(0xFF92400E),

    // Info - Tailwind Sky
    info = Color(0xFF0EA5E9),
    onInfo = DesdyColorPrimitives.White,
    infoContainer = Color(0xFFE0F2FE),
    onInfoContainer = Color(0xFF0C4A6E),

    // Special
    scrim = Color(0x52000000),
    disabled = DesdyColorPrimitives.Slate400,
    onDisabled = DesdyColorPrimitives.Slate500,
    divider = DesdyColorPrimitives.Slate200
)

/**
 * Dark color scheme for Desdy Design System.
 * Inverted palette with softer contrasts for dark mode.
 */
val DesdyDarkColors = DesdyColors(
    // Primary - Blue (lighter for dark theme)
    primary = DesdyColorPrimitives.Blue400,
    onPrimary = DesdyColorPrimitives.Blue900,
    primaryContainer = DesdyColorPrimitives.Blue900,
    onPrimaryContainer = DesdyColorPrimitives.Blue100,

    // Secondary - Slate
    secondary = DesdyColorPrimitives.Slate400,
    onSecondary = DesdyColorPrimitives.Slate800,
    secondaryContainer = DesdyColorPrimitives.Slate700,
    onSecondaryContainer = DesdyColorPrimitives.Slate100,

    // Tertiary - Emerald
    tertiary = DesdyColorPrimitives.Emerald400,
    onTertiary = DesdyColorPrimitives.Emerald900,
    tertiaryContainer = DesdyColorPrimitives.Emerald900,
    onTertiaryContainer = DesdyColorPrimitives.Emerald100,

    // Background and Surface - Dark slate neutrals
    background = DesdyColorPrimitives.Slate900,
    onBackground = DesdyColorPrimitives.Slate100,
    surface = DesdyColorPrimitives.Slate800,
    onSurface = DesdyColorPrimitives.Slate200,
    surfaceVariant = DesdyColorPrimitives.Slate700,
    onSurfaceVariant = DesdyColorPrimitives.Slate400,
    surfaceTint = DesdyColorPrimitives.Blue400,
    surfaceContainerLowest = DesdyColorPrimitives.Slate950,
    surfaceContainerLow = DesdyColorPrimitives.Slate900,
    surfaceContainer = DesdyColorPrimitives.Slate600,
    surfaceContainerHigh = DesdyColorPrimitives.Slate700,
    surfaceContainerHighest = DesdyColorPrimitives.Slate600,

    // Inverse
    inverseSurface = DesdyColorPrimitives.Slate100,
    inverseOnSurface = DesdyColorPrimitives.Slate800,
    inversePrimary = DesdyColorPrimitives.Blue600,

    // Outline
    outline = DesdyColorPrimitives.Slate600,
    outlineVariant = DesdyColorPrimitives.Slate700,

    // Error - Tailwind Red (dark)
    error = Color(0xFFF87171),
    onError = Color(0xFF7F1D1D),
    errorContainer = Color(0xFF7F1D1D),
    onErrorContainer = Color(0xFFFECACA),

    // Success - Tailwind Green (dark)
    success = Color(0xFF4ADE80),
    onSuccess = Color(0xFF166534),
    successContainer = Color(0xFF166534),
    onSuccessContainer = Color(0xFFBBF7D0),

    // Warning - Tailwind Amber (dark)
    warning = Color(0xFFFBBF24),
    onWarning = Color(0xFF78350F),
    warningContainer = Color(0xFF78350F),
    onWarningContainer = Color(0xFFFDE68A),

    // Info - Tailwind Sky (dark)
    info = Color(0xFF38BDF8),
    onInfo = Color(0xFF0C4A6E),
    infoContainer = Color(0xFF0C4A6E),
    onInfoContainer = Color(0xFFBAE6FD),

    // Special
    scrim = Color(0x80000000),
    disabled = DesdyColorPrimitives.Slate500,
    onDisabled = DesdyColorPrimitives.Slate600,
    divider = DesdyColorPrimitives.Slate700
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

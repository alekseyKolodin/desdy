package com.desdy.platform

import androidx.compose.runtime.Composable

/**
 * Platform-specific utilities for Desdy Design System.
 */

/**
 * Returns true if the system is currently using dark theme.
 * Platform-specific implementation.
 */
@Composable
expect fun isSystemInDarkTheme(): Boolean

/**
 * Provides haptic feedback on supported platforms.
 * No-op on platforms without haptic support.
 */
expect fun provideHapticFeedback()

package com.desdy.platform

import androidx.compose.runtime.Composable

@Composable
actual fun isSystemInDarkTheme(): Boolean {
    // Desktop: Default to dark theme for SoulSync
    // In production, you could detect OS theme using JNA or similar
    return true
}

actual fun provideHapticFeedback() {
    // Desktop: No haptic feedback support
    // Could potentially play a subtle sound effect instead
}

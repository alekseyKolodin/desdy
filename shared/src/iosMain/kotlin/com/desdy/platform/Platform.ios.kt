package com.desdy.platform

import androidx.compose.runtime.Composable
import platform.UIKit.UITraitCollection
import platform.UIKit.UIUserInterfaceStyle

@Composable
actual fun isSystemInDarkTheme(): Boolean {
    val currentTraitCollection = UITraitCollection.currentTraitCollection
    return currentTraitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}

actual fun provideHapticFeedback() {
    // iOS haptic feedback using UIImpactFeedbackGenerator
    // Note: In production, you'd use UIImpactFeedbackGenerator
}

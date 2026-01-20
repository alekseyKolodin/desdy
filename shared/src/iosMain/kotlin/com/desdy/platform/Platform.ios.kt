package com.desdy.platform

import androidx.compose.runtime.Composable
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

@Composable
actual fun isSystemInDarkTheme(): Boolean {
    val traitCollection = UIScreen.mainScreen.traitCollection
    return traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}

actual fun provideHapticFeedback() {
    // iOS haptic feedback using UIImpactFeedbackGenerator
    // Note: In production, you'd use UIImpactFeedbackGenerator
}

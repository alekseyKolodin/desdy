package com.desdy.platform

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.foundation.isSystemInDarkTheme as androidIsSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun isSystemInDarkTheme(): Boolean = androidIsSystemInDarkTheme()

actual fun provideHapticFeedback() {
    // Note: This is a simplified implementation.
    // In production, you'd want to use LocalContext or pass Context as parameter.
}

/**
 * Provides haptic feedback on Android.
 * Call this from a Composable context.
 */
@Composable
fun provideHapticFeedbackWithContext() {
    val context = LocalContext.current
    val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrator.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        @Suppress("DEPRECATION")
        vibrator.vibrate(10)
    }
}

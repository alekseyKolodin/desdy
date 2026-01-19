package com.desdy.components.gauge

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.desdy.foundation.color.DesdyColorPrimitives
import com.desdy.theme.DesdyTheme

/**
 * Temperature color ranges for SoulSync relationship temperature.
 */
object TemperatureColors {
    /** Cold (0-30): Blue - Needs attention */
    val Cold = DesdyColorPrimitives.TempCold

    /** Neutral (31-60): Yellow - Okay */
    val Neutral = DesdyColorPrimitives.TempNeutral

    /** Warm (61-85): Green - Great relationship! */
    val Warm = DesdyColorPrimitives.TempWarm

    /** Hot (86-100): Red - At the peak! */
    val Hot = DesdyColorPrimitives.TempHot

    /**
     * Get color for a given temperature value.
     */
    fun getColorForTemperature(temperature: Int): Color {
        return when {
            temperature <= 30 -> Cold
            temperature <= 60 -> Neutral
            temperature <= 85 -> Warm
            else -> Hot
        }
    }

    /**
     * Get emoji for a given temperature value.
     */
    fun getEmojiForTemperature(temperature: Int): String {
        return when {
            temperature <= 30 -> "\uD83E\uDD76" // Cold face
            temperature <= 60 -> "\uD83D\uDFE1" // Yellow circle
            temperature <= 85 -> "\uD83D\uDD25" // Fire
            else -> "\u2764\uFE0F" // Red heart
        }
    }

    /**
     * Get label for a given temperature value.
     */
    fun getLabelForTemperature(temperature: Int): String {
        return when {
            temperature <= 30 -> "Needs attention"
            temperature <= 60 -> "Normal"
            temperature <= 85 -> "Great relationship!"
            else -> "At the peak!"
        }
    }
}

/**
 * SoulSync Temperature Gauge.
 *
 * Circular progress indicator showing relationship "temperature" from 0-100.
 *
 * @param temperature Current temperature value (0-100).
 * @param modifier Modifier for the gauge.
 * @param size Size of the gauge.
 * @param strokeWidth Width of the progress arc.
 * @param trackColor Color of the background track.
 * @param showLabel Whether to show the temperature label.
 * @param showEmoji Whether to show the emoji indicator.
 * @param animated Whether to animate changes.
 */
@Composable
fun TemperatureGauge(
    temperature: Int,
    modifier: Modifier = Modifier,
    size: Dp = 160.dp,
    strokeWidth: Dp = 12.dp,
    trackColor: Color = DesdyTheme.colors.surfaceVariant,
    showLabel: Boolean = true,
    showEmoji: Boolean = true,
    animated: Boolean = true
) {
    val clampedTemperature = temperature.coerceIn(0, 100)
    val progress = clampedTemperature / 100f
    val progressColor = TemperatureColors.getColorForTemperature(clampedTemperature)

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = if (animated) 500 else 0),
        label = "temperature_progress"
    )

    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(size)) {
            val strokeWidthPx = strokeWidth.toPx()
            val arcSize = Size(
                width = this.size.width - strokeWidthPx,
                height = this.size.height - strokeWidthPx
            )
            val topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2)

            // Draw background track
            drawArc(
                color = trackColor,
                startAngle = 135f,
                sweepAngle = 270f,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round)
            )

            // Draw progress arc
            drawArc(
                color = progressColor,
                startAngle = 135f,
                sweepAngle = 270f * animatedProgress,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = strokeWidthPx, cap = StrokeCap.Round)
            )
        }

        // Center content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showEmoji) {
                Text(
                    text = TemperatureColors.getEmojiForTemperature(clampedTemperature),
                    style = DesdyTheme.typography.headlineMedium
                )
            }
            Text(
                text = "$clampedTemperature",
                style = DesdyTheme.typography.displaySmall,
                color = progressColor
            )
            if (showLabel) {
                Text(
                    text = TemperatureColors.getLabelForTemperature(clampedTemperature),
                    style = DesdyTheme.typography.labelSmall,
                    color = DesdyTheme.colors.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

/**
 * Compact temperature gauge.
 *
 * Smaller version without label.
 */
@Composable
fun CompactTemperatureGauge(
    temperature: Int,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp,
    strokeWidth: Dp = 8.dp
) {
    TemperatureGauge(
        temperature = temperature,
        modifier = modifier,
        size = size,
        strokeWidth = strokeWidth,
        showLabel = false,
        showEmoji = false
    )
}

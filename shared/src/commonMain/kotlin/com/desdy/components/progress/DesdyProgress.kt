package com.desdy.components.progress

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy linear progress indicator (determinate).
 *
 * Shows progress from 0 to 1.
 *
 * @param progress Current progress (0f to 1f).
 * @param modifier Modifier for the indicator.
 * @param color Progress color.
 * @param trackColor Track/background color.
 */
@Composable
fun DesdyLinearProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.primary,
    trackColor: Color = DesdyTheme.colors.surfaceVariant
) {
    LinearProgressIndicator(
        progress = progress,
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        strokeCap = StrokeCap.Round
    )
}

/**
 * Desdy linear progress indicator (indeterminate).
 *
 * Shows indefinite loading state.
 */
@Composable
fun DesdyLinearProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.primary,
    trackColor: Color = DesdyTheme.colors.surfaceVariant
) {
    LinearProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        strokeCap = StrokeCap.Round
    )
}

/**
 * Desdy circular progress indicator (determinate).
 *
 * @param progress Current progress (0f to 1f).
 * @param modifier Modifier for the indicator.
 * @param color Progress color.
 * @param trackColor Track/background color.
 * @param strokeWidth Width of the progress stroke.
 */
@Composable
fun DesdyCircularProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.primary,
    trackColor: Color = DesdyTheme.colors.surfaceVariant,
    strokeWidth: Dp = 4.dp
) {
    CircularProgressIndicator(
        progress = progress,
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        strokeWidth = strokeWidth,
        strokeCap = StrokeCap.Round
    )
}

/**
 * Desdy circular progress indicator (indeterminate).
 *
 * @param modifier Modifier for the indicator.
 * @param color Progress color.
 * @param strokeWidth Width of the progress stroke.
 */
@Composable
fun DesdyCircularProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.primary,
    strokeWidth: Dp = 4.dp
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        strokeWidth = strokeWidth,
        strokeCap = StrokeCap.Round
    )
}

/**
 * Size presets for circular progress indicators.
 */
object DesdyProgressSize {
    val Small = 24.dp
    val Medium = 40.dp
    val Large = 64.dp
}

/**
 * Small circular progress indicator.
 */
@Composable
fun DesdySmallCircularProgress(
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.primary
) {
    DesdyCircularProgressIndicator(
        modifier = modifier.size(DesdyProgressSize.Small),
        color = color,
        strokeWidth = 2.dp
    )
}

/**
 * Medium circular progress indicator.
 */
@Composable
fun DesdyMediumCircularProgress(
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.primary
) {
    DesdyCircularProgressIndicator(
        modifier = modifier.size(DesdyProgressSize.Medium),
        color = color,
        strokeWidth = 4.dp
    )
}

/**
 * Large circular progress indicator.
 */
@Composable
fun DesdyLargeCircularProgress(
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.primary
) {
    DesdyCircularProgressIndicator(
        modifier = modifier.size(DesdyProgressSize.Large),
        color = color,
        strokeWidth = 6.dp
    )
}

package com.desdy.components.progress

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * SoulSync Step Progress Bar.
 *
 * Shows progress through a multi-step flow with animated transitions.
 *
 * @param currentStep Current step (1-based index).
 * @param totalSteps Total number of steps.
 * @param modifier Modifier for the progress bar.
 * @param activeColor Color for completed and current steps.
 * @param inactiveColor Color for upcoming steps.
 * @param showLabels Whether to show step numbers.
 * @param showStepText Whether to show "Step X of Y" text.
 * @param animated Whether to animate transitions.
 */
@Composable
fun StepProgressBar(
    currentStep: Int,
    totalSteps: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = DesdyTheme.colors.primary,
    inactiveColor: Color = DesdyTheme.colors.surfaceVariant,
    showLabels: Boolean = false,
    showStepText: Boolean = true,
    animated: Boolean = true
) {
    require(totalSteps > 0) { "totalSteps must be positive" }
    require(currentStep in 1..totalSteps) { "currentStep must be between 1 and totalSteps" }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Step text
        if (showStepText) {
            Text(
                text = "Step $currentStep of $totalSteps",
                style = DesdyTheme.typography.labelMedium,
                color = DesdyTheme.colors.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Step indicators
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (step in 1..totalSteps) {
                val isCompleted = step < currentStep
                val isCurrent = step == currentStep

                // Step indicator
                StepIndicator(
                    step = step,
                    isCompleted = isCompleted,
                    isCurrent = isCurrent,
                    activeColor = activeColor,
                    inactiveColor = inactiveColor,
                    showLabel = showLabels,
                    animated = animated
                )

                // Connector line (not after last step)
                if (step < totalSteps) {
                    StepConnector(
                        isCompleted = isCompleted,
                        activeColor = activeColor,
                        inactiveColor = inactiveColor,
                        animated = animated,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun StepIndicator(
    step: Int,
    isCompleted: Boolean,
    isCurrent: Boolean,
    activeColor: Color,
    inactiveColor: Color,
    showLabel: Boolean,
    animated: Boolean
) {
    val backgroundColor by animateColorAsState(
        targetValue = when {
            isCompleted || isCurrent -> activeColor
            else -> inactiveColor
        },
        animationSpec = tween(durationMillis = if (animated) 300 else 0),
        label = "step_bg_color"
    )

    val contentColor by animateColorAsState(
        targetValue = when {
            isCompleted || isCurrent -> DesdyTheme.colors.onPrimary
            else -> DesdyTheme.colors.onSurfaceVariant
        },
        animationSpec = tween(durationMillis = if (animated) 300 else 0),
        label = "step_content_color"
    )

    val size by animateFloatAsState(
        targetValue = if (isCurrent) 1.2f else 1f,
        animationSpec = tween(durationMillis = if (animated) 300 else 0),
        label = "step_size"
    )

    Box(
        modifier = Modifier
            .size((24 * size).dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        if (isCompleted) {
            // Checkmark for completed
            Text(
                text = "\u2713", // ✓
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
        } else if (showLabel) {
            Text(
                text = "$step",
                style = DesdyTheme.typography.labelSmall,
                color = contentColor,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun StepConnector(
    isCompleted: Boolean,
    activeColor: Color,
    inactiveColor: Color,
    animated: Boolean,
    modifier: Modifier = Modifier
) {
    val lineColor by animateColorAsState(
        targetValue = if (isCompleted) activeColor else inactiveColor,
        animationSpec = tween(durationMillis = if (animated) 300 else 0),
        label = "connector_color"
    )

    Box(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .height(2.dp)
            .background(lineColor)
    )
}

/**
 * Compact Step Progress Bar.
 *
 * Smaller version using dots instead of numbered circles.
 *
 * @param currentStep Current step (1-based index).
 * @param totalSteps Total number of steps.
 * @param modifier Modifier for the progress bar.
 * @param dotSize Size of each dot.
 * @param activeColor Color for completed and current dots.
 * @param inactiveColor Color for upcoming dots.
 */
@Composable
fun DotProgressBar(
    currentStep: Int,
    totalSteps: Int,
    modifier: Modifier = Modifier,
    dotSize: Dp = 8.dp,
    activeColor: Color = DesdyTheme.colors.primary,
    inactiveColor: Color = DesdyTheme.colors.surfaceVariant
) {
    require(totalSteps > 0) { "totalSteps must be positive" }
    require(currentStep in 1..totalSteps) { "currentStep must be between 1 and totalSteps" }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 1..totalSteps) {
            val isActive = step <= currentStep
            val isCurrent = step == currentStep

            val color by animateColorAsState(
                targetValue = if (isActive) activeColor else inactiveColor,
                animationSpec = tween(durationMillis = 300),
                label = "dot_color"
            )

            val size by animateFloatAsState(
                targetValue = if (isCurrent) 1.4f else 1f,
                animationSpec = tween(durationMillis = 200),
                label = "dot_size"
            )

            Box(
                modifier = Modifier
                    .size(dotSize * size)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

/**
 * Linear Step Progress Bar.
 *
 * Single line progress indicator showing step completion.
 *
 * @param currentStep Current step (1-based index).
 * @param totalSteps Total number of steps.
 * @param modifier Modifier for the progress bar.
 * @param height Height of the progress bar.
 * @param activeColor Color for completed portion.
 * @param inactiveColor Color for remaining portion.
 * @param showPercentage Whether to show completion percentage.
 */
@Composable
fun LinearStepProgress(
    currentStep: Int,
    totalSteps: Int,
    modifier: Modifier = Modifier,
    height: Dp = 4.dp,
    activeColor: Color = DesdyTheme.colors.primary,
    inactiveColor: Color = DesdyTheme.colors.surfaceVariant,
    showPercentage: Boolean = false
) {
    require(totalSteps > 0) { "totalSteps must be positive" }
    require(currentStep in 0..totalSteps) { "currentStep must be between 0 and totalSteps" }

    val progress = currentStep.toFloat() / totalSteps

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 500),
        label = "linear_progress"
    )

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        if (showPercentage) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Step $currentStep of $totalSteps",
                    style = DesdyTheme.typography.labelSmall,
                    color = DesdyTheme.colors.onSurfaceVariant
                )
                Text(
                    text = "${(animatedProgress * 100).toInt()}%",
                    style = DesdyTheme.typography.labelSmall,
                    color = activeColor,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clip(CircleShape)
                .background(inactiveColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(animatedProgress)
                    .height(height)
                    .clip(CircleShape)
                    .background(activeColor)
            )
        }
    }
}

/**
 * Step Progress Bar with labels.
 *
 * Shows step names below each indicator.
 *
 * @param currentStep Current step (1-based index).
 * @param stepLabels List of labels for each step.
 * @param modifier Modifier for the progress bar.
 * @param activeColor Color for completed and current steps.
 * @param inactiveColor Color for upcoming steps.
 */
@Composable
fun LabeledStepProgressBar(
    currentStep: Int,
    stepLabels: List<String>,
    modifier: Modifier = Modifier,
    activeColor: Color = DesdyTheme.colors.primary,
    inactiveColor: Color = DesdyTheme.colors.surfaceVariant
) {
    val totalSteps = stepLabels.size
    require(totalSteps > 0) { "stepLabels must not be empty" }
    require(currentStep in 1..totalSteps) { "currentStep must be between 1 and totalSteps" }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Step indicators
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            stepLabels.forEachIndexed { index, _ ->
                val step = index + 1
                val isCompleted = step < currentStep
                val isCurrent = step == currentStep

                StepIndicator(
                    step = step,
                    isCompleted = isCompleted,
                    isCurrent = isCurrent,
                    activeColor = activeColor,
                    inactiveColor = inactiveColor,
                    showLabel = true,
                    animated = true
                )

                if (step < totalSteps) {
                    StepConnector(
                        isCompleted = isCompleted,
                        activeColor = activeColor,
                        inactiveColor = inactiveColor,
                        animated = true,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Step labels
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            stepLabels.forEachIndexed { index, label ->
                val step = index + 1
                val isActive = step <= currentStep

                val labelColor by animateColorAsState(
                    targetValue = if (isActive) activeColor else DesdyTheme.colors.onSurfaceVariant,
                    animationSpec = tween(durationMillis = 300),
                    label = "label_color"
                )

                Text(
                    text = label,
                    style = DesdyTheme.typography.labelSmall,
                    color = labelColor,
                    modifier = Modifier.width(60.dp),
                    maxLines = 1
                )
            }
        }
    }
}

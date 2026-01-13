package com.desdy.components.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.desdy.theme.DesdyTheme

/**
 * Desdy slider.
 *
 * @param value Current value.
 * @param onValueChange Called when value changes.
 * @param modifier Modifier for the slider.
 * @param enabled Whether the slider is enabled.
 * @param valueRange Range of values.
 * @param steps Number of discrete steps (0 for continuous).
 * @param onValueChangeFinished Called when user finishes changing value.
 */
@Composable
fun DesdySlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = SliderDefaults.colors(
            thumbColor = DesdyTheme.colors.primary,
            activeTrackColor = DesdyTheme.colors.primary,
            activeTickColor = DesdyTheme.colors.onPrimary,
            inactiveTrackColor = DesdyTheme.colors.surfaceVariant,
            inactiveTickColor = DesdyTheme.colors.onSurfaceVariant,
            disabledThumbColor = DesdyTheme.colors.disabled,
            disabledActiveTrackColor = DesdyTheme.colors.disabled,
            disabledActiveTickColor = DesdyTheme.colors.onDisabled,
            disabledInactiveTrackColor = DesdyTheme.colors.surfaceVariant,
            disabledInactiveTickColor = DesdyTheme.colors.onDisabled
        )
    )
}

/**
 * Desdy labeled slider.
 *
 * Slider with label and current value display.
 *
 * @param value Current value.
 * @param onValueChange Called when value changes.
 * @param modifier Modifier for the component.
 * @param label Label text.
 * @param valueLabel Function to format value for display.
 * @param enabled Whether the slider is enabled.
 * @param valueRange Range of values.
 * @param steps Number of discrete steps (0 for continuous).
 * @param onValueChangeFinished Called when user finishes changing value.
 */
@Composable
fun DesdyLabeledSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    valueLabel: (Float) -> String = { "%.0f".format(it) },
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..100f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        if (label != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = label,
                    style = DesdyTheme.typography.labelLarge,
                    color = if (enabled) {
                        DesdyTheme.colors.onSurface
                    } else {
                        DesdyTheme.colors.onDisabled
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = valueLabel(value),
                    style = DesdyTheme.typography.bodyMedium,
                    color = if (enabled) {
                        DesdyTheme.colors.primary
                    } else {
                        DesdyTheme.colors.onDisabled
                    }
                )
            }
            Spacer(modifier = Modifier.height(DesdyTheme.spacing.small))
        }
        DesdySlider(
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            valueRange = valueRange,
            steps = steps,
            onValueChangeFinished = onValueChangeFinished
        )
    }
}

/**
 * Desdy range slider.
 *
 * Slider for selecting a range of values.
 *
 * @param value Current range.
 * @param onValueChange Called when range changes.
 * @param modifier Modifier for the slider.
 * @param enabled Whether the slider is enabled.
 * @param valueRange Range of values.
 * @param steps Number of discrete steps (0 for continuous).
 * @param onValueChangeFinished Called when user finishes changing value.
 */
@Composable
fun DesdyRangeSlider(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null
) {
    RangeSlider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = SliderDefaults.colors(
            thumbColor = DesdyTheme.colors.primary,
            activeTrackColor = DesdyTheme.colors.primary,
            activeTickColor = DesdyTheme.colors.onPrimary,
            inactiveTrackColor = DesdyTheme.colors.surfaceVariant,
            inactiveTickColor = DesdyTheme.colors.onSurfaceVariant,
            disabledThumbColor = DesdyTheme.colors.disabled,
            disabledActiveTrackColor = DesdyTheme.colors.disabled,
            disabledActiveTickColor = DesdyTheme.colors.onDisabled,
            disabledInactiveTrackColor = DesdyTheme.colors.surfaceVariant,
            disabledInactiveTickColor = DesdyTheme.colors.onDisabled
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DesdySliderPreview() {
    DesdyTheme {
        DesdySlider(
            value = 0.5f,
            onValueChange = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesdyLabeledSliderPreview() {
    DesdyTheme {
        DesdyLabeledSlider(
            value = 50f,
            onValueChange = { },
            label = "Volume"
        )
    }
}

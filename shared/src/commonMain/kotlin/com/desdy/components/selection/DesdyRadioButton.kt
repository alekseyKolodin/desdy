package com.desdy.components.selection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import com.desdy.theme.DesdyTheme

/**
 * Desdy radio button.
 *
 * @param selected Whether the radio button is selected.
 * @param onClick Called when the radio button is clicked.
 * @param modifier Modifier for the radio button.
 * @param enabled Whether the radio button is enabled.
 */
@Composable
fun DesdyRadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = RadioButtonDefaults.colors(
            selectedColor = DesdyTheme.colors.primary,
            unselectedColor = DesdyTheme.colors.onSurfaceVariant,
            disabledSelectedColor = DesdyTheme.colors.disabled,
            disabledUnselectedColor = DesdyTheme.colors.disabled
        )
    )
}

/**
 * Desdy labeled radio button.
 *
 * Radio button with accompanying label text.
 */
@Composable
fun DesdyLabeledRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .selectable(
                selected = selected,
                enabled = enabled,
                role = Role.RadioButton,
                onClick = onClick
            )
            .padding(DesdyTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DesdyRadioButton(
            selected = selected,
            onClick = null,
            enabled = enabled
        )
        Spacer(modifier = Modifier.width(DesdyTheme.spacing.small))
        Text(
            text = label,
            style = DesdyTheme.typography.bodyMedium,
            color = if (enabled) {
                DesdyTheme.colors.onSurface
            } else {
                DesdyTheme.colors.onDisabled
            }
        )
    }
}

/**
 * Desdy radio button group.
 *
 * Helper composable for creating a group of radio buttons.
 *
 * @param options List of options to display.
 * @param selected Currently selected option.
 * @param onSelectedChange Called when selection changes.
 * @param modifier Modifier for the group.
 * @param optionLabel Function to get label for each option.
 * @param enabled Whether the group is enabled.
 */
@Composable
fun <T> DesdyRadioGroup(
    options: List<T>,
    selected: T,
    onSelectedChange: (T) -> Unit,
    modifier: Modifier = Modifier,
    optionLabel: (T) -> String = { it.toString() },
    enabled: Boolean = true
) {
    Column(modifier = modifier.selectableGroup()) {
        options.forEach { option ->
            DesdyLabeledRadioButton(
                selected = option == selected,
                onClick = { onSelectedChange(option) },
                label = optionLabel(option),
                enabled = enabled
            )
        }
    }
}

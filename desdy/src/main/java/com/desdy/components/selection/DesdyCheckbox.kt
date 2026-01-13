package com.desdy.components.selection

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import com.desdy.theme.DesdyTheme

/**
 * Desdy checkbox.
 *
 * @param checked Whether the checkbox is checked.
 * @param onCheckedChange Called when the checkbox state changes.
 * @param modifier Modifier for the checkbox.
 * @param enabled Whether the checkbox is enabled.
 */
@Composable
fun DesdyCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = CheckboxDefaults.colors(
            checkedColor = DesdyTheme.colors.primary,
            uncheckedColor = DesdyTheme.colors.onSurfaceVariant,
            checkmarkColor = DesdyTheme.colors.onPrimary,
            disabledCheckedColor = DesdyTheme.colors.disabled,
            disabledUncheckedColor = DesdyTheme.colors.disabled,
            disabledIndeterminateColor = DesdyTheme.colors.disabled
        )
    )
}

/**
 * Desdy tri-state checkbox.
 *
 * Supports checked, unchecked, and indeterminate states.
 */
@Composable
fun DesdyTriStateCheckbox(
    state: ToggleableState,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TriStateCheckbox(
        state = state,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = CheckboxDefaults.colors(
            checkedColor = DesdyTheme.colors.primary,
            uncheckedColor = DesdyTheme.colors.onSurfaceVariant,
            checkmarkColor = DesdyTheme.colors.onPrimary,
            disabledCheckedColor = DesdyTheme.colors.disabled,
            disabledUncheckedColor = DesdyTheme.colors.disabled,
            disabledIndeterminateColor = DesdyTheme.colors.disabled
        )
    )
}

/**
 * Desdy labeled checkbox.
 *
 * Checkbox with accompanying label text.
 *
 * @param checked Whether the checkbox is checked.
 * @param onCheckedChange Called when the checkbox state changes.
 * @param label Label text.
 * @param modifier Modifier for the row.
 * @param enabled Whether the checkbox is enabled.
 */
@Composable
fun DesdyLabeledCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .toggleable(
                value = checked,
                enabled = enabled,
                role = Role.Checkbox,
                onValueChange = onCheckedChange
            )
            .padding(DesdyTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DesdyCheckbox(
            checked = checked,
            onCheckedChange = null,
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

@Preview(showBackground = true)
@Composable
private fun DesdyCheckboxPreview() {
    DesdyTheme {
        DesdyCheckbox(
            checked = true,
            onCheckedChange = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesdyLabeledCheckboxPreview() {
    DesdyTheme {
        DesdyLabeledCheckbox(
            checked = true,
            onCheckedChange = { },
            label = "Accept terms"
        )
    }
}

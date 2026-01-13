package com.desdy.components.selection

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.desdy.theme.DesdyTheme

/**
 * Desdy switch (toggle).
 *
 * @param checked Whether the switch is on.
 * @param onCheckedChange Called when the switch state changes.
 * @param modifier Modifier for the switch.
 * @param enabled Whether the switch is enabled.
 * @param thumbContent Optional content for the thumb.
 */
@Composable
fun DesdySwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    thumbContent: (@Composable () -> Unit)? = null
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        thumbContent = thumbContent,
        colors = SwitchDefaults.colors(
            checkedThumbColor = DesdyTheme.colors.onPrimary,
            checkedTrackColor = DesdyTheme.colors.primary,
            checkedBorderColor = DesdyTheme.colors.primary,
            checkedIconColor = DesdyTheme.colors.primary,
            uncheckedThumbColor = DesdyTheme.colors.outline,
            uncheckedTrackColor = DesdyTheme.colors.surfaceVariant,
            uncheckedBorderColor = DesdyTheme.colors.outline,
            uncheckedIconColor = DesdyTheme.colors.surfaceVariant,
            disabledCheckedThumbColor = DesdyTheme.colors.surface,
            disabledCheckedTrackColor = DesdyTheme.colors.disabled,
            disabledCheckedBorderColor = DesdyTheme.colors.disabled,
            disabledUncheckedThumbColor = DesdyTheme.colors.disabled,
            disabledUncheckedTrackColor = DesdyTheme.colors.surfaceVariant,
            disabledUncheckedBorderColor = DesdyTheme.colors.disabled
        )
    )
}

/**
 * Desdy labeled switch.
 *
 * Switch with accompanying label text.
 *
 * @param checked Whether the switch is on.
 * @param onCheckedChange Called when the switch state changes.
 * @param label Label text.
 * @param modifier Modifier for the row.
 * @param enabled Whether the switch is enabled.
 */
@Composable
fun DesdyLabeledSwitch(
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
                role = Role.Switch,
                onValueChange = onCheckedChange
            )
            .padding(DesdyTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = DesdyTheme.typography.bodyMedium,
            color = if (enabled) {
                DesdyTheme.colors.onSurface
            } else {
                DesdyTheme.colors.onDisabled
            },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(DesdyTheme.spacing.medium))
        DesdySwitch(
            checked = checked,
            onCheckedChange = null,
            enabled = enabled
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesdySwitchPreview() {
    DesdyTheme {
        DesdySwitch(
            checked = true,
            onCheckedChange = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesdyLabeledSwitchPreview() {
    DesdyTheme {
        DesdyLabeledSwitch(
            checked = true,
            onCheckedChange = { },
            label = "Enable notifications"
        )
    }
}

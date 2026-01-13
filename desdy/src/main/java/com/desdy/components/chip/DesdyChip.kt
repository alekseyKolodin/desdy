package com.desdy.components.chip

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy assist chip.
 *
 * Use for smart suggestions or quick actions.
 *
 * @param label Chip label.
 * @param onClick Called when chip is clicked.
 * @param modifier Modifier for the chip.
 * @param enabled Whether the chip is enabled.
 * @param leadingIcon Optional leading icon.
 */
@Composable
fun DesdyAssistChip(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null
) {
    AssistChip(
        onClick = onClick,
        label = { Text(label) },
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        shape = DesdyTheme.shapes.small,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = DesdyTheme.colors.surface,
            labelColor = DesdyTheme.colors.onSurface,
            leadingIconContentColor = DesdyTheme.colors.primary,
            disabledContainerColor = DesdyTheme.colors.surfaceVariant,
            disabledLabelColor = DesdyTheme.colors.onDisabled,
            disabledLeadingIconContentColor = DesdyTheme.colors.onDisabled
        ),
        border = AssistChipDefaults.assistChipBorder(
            enabled = enabled,
            borderColor = DesdyTheme.colors.outline,
            disabledBorderColor = DesdyTheme.colors.disabled
        )
    )
}

/**
 * Desdy filter chip.
 *
 * Use for filtering content.
 *
 * @param label Chip label.
 * @param selected Whether the chip is selected.
 * @param onClick Called when chip is clicked.
 * @param modifier Modifier for the chip.
 * @param enabled Whether the chip is enabled.
 * @param leadingIcon Optional leading icon (shown when not selected).
 */
@Composable
fun DesdyFilterChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        modifier = modifier,
        enabled = enabled,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        } else leadingIcon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        shape = DesdyTheme.shapes.small,
        colors = FilterChipDefaults.filterChipColors(
            containerColor = DesdyTheme.colors.surface,
            labelColor = DesdyTheme.colors.onSurface,
            iconColor = DesdyTheme.colors.onSurfaceVariant,
            selectedContainerColor = DesdyTheme.colors.secondaryContainer,
            selectedLabelColor = DesdyTheme.colors.onSecondaryContainer,
            selectedLeadingIconColor = DesdyTheme.colors.onSecondaryContainer,
            disabledContainerColor = DesdyTheme.colors.surfaceVariant,
            disabledLabelColor = DesdyTheme.colors.onDisabled,
            disabledLeadingIconColor = DesdyTheme.colors.onDisabled,
            disabledSelectedContainerColor = DesdyTheme.colors.disabled
        ),
        border = FilterChipDefaults.filterChipBorder(
            enabled = enabled,
            selected = selected,
            borderColor = DesdyTheme.colors.outline,
            selectedBorderColor = DesdyTheme.colors.secondaryContainer,
            disabledBorderColor = DesdyTheme.colors.disabled,
            disabledSelectedBorderColor = DesdyTheme.colors.disabled
        )
    )
}

/**
 * Desdy input chip.
 *
 * Use for user input, tags, or selections that can be removed.
 *
 * @param label Chip label.
 * @param selected Whether the chip is selected.
 * @param onClick Called when chip is clicked.
 * @param onRemove Called when remove button is clicked. If null, no remove button.
 * @param modifier Modifier for the chip.
 * @param enabled Whether the chip is enabled.
 * @param avatar Optional avatar content.
 */
@Composable
fun DesdyInputChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onRemove: (() -> Unit)? = null,
    enabled: Boolean = true,
    avatar: @Composable (() -> Unit)? = null
) {
    InputChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        modifier = modifier,
        enabled = enabled,
        avatar = avatar,
        trailingIcon = onRemove?.let {
            {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Remove",
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        shape = DesdyTheme.shapes.small,
        colors = InputChipDefaults.inputChipColors(
            containerColor = DesdyTheme.colors.surface,
            labelColor = DesdyTheme.colors.onSurface,
            trailingIconColor = DesdyTheme.colors.onSurfaceVariant,
            selectedContainerColor = DesdyTheme.colors.secondaryContainer,
            selectedLabelColor = DesdyTheme.colors.onSecondaryContainer,
            selectedTrailingIconColor = DesdyTheme.colors.onSecondaryContainer,
            disabledContainerColor = DesdyTheme.colors.surfaceVariant,
            disabledLabelColor = DesdyTheme.colors.onDisabled,
            disabledTrailingIconColor = DesdyTheme.colors.onDisabled
        ),
        border = InputChipDefaults.inputChipBorder(
            enabled = enabled,
            selected = selected,
            borderColor = DesdyTheme.colors.outline,
            selectedBorderColor = DesdyTheme.colors.secondaryContainer,
            disabledBorderColor = DesdyTheme.colors.disabled,
            disabledSelectedBorderColor = DesdyTheme.colors.disabled
        )
    )
}

/**
 * Desdy suggestion chip.
 *
 * Use for showing suggestions.
 *
 * @param label Chip label.
 * @param onClick Called when chip is clicked.
 * @param modifier Modifier for the chip.
 * @param enabled Whether the chip is enabled.
 * @param icon Optional icon.
 */
@Composable
fun DesdySuggestionChip(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null
) {
    SuggestionChip(
        onClick = onClick,
        label = { Text(label) },
        modifier = modifier,
        enabled = enabled,
        icon = icon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        shape = DesdyTheme.shapes.small,
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = DesdyTheme.colors.surface,
            labelColor = DesdyTheme.colors.onSurface,
            iconContentColor = DesdyTheme.colors.onSurfaceVariant,
            disabledContainerColor = DesdyTheme.colors.surfaceVariant,
            disabledLabelColor = DesdyTheme.colors.onDisabled,
            disabledIconContentColor = DesdyTheme.colors.onDisabled
        ),
        border = SuggestionChipDefaults.suggestionChipBorder(
            enabled = enabled,
            borderColor = DesdyTheme.colors.outline,
            disabledBorderColor = DesdyTheme.colors.disabled
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun DesdyFilterChipPreview() {
    DesdyTheme {
        DesdyFilterChip(
            label = "Filter",
            selected = true,
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesdyInputChipPreview() {
    DesdyTheme {
        DesdyInputChip(
            label = "Tag",
            selected = false,
            onClick = { },
            onRemove = { }
        )
    }
}

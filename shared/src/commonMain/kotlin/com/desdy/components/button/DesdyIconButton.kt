package com.desdy.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy standard icon button.
 *
 * @param icon Icon to display.
 * @param onClick Called when button is clicked.
 * @param modifier Modifier for the button.
 * @param enabled Whether the button is enabled.
 * @param contentDescription Accessibility description.
 */
@Composable
fun DesdyIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentDescription: String? = null
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = DesdyTheme.colors.onSurfaceVariant,
            disabledContentColor = DesdyTheme.colors.onDisabled
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}

/**
 * Desdy filled icon button.
 *
 * Use for high-emphasis icon actions.
 */
@Composable
fun DesdyFilledIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentDescription: String? = null
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = DesdyTheme.colors.primary,
            contentColor = DesdyTheme.colors.onPrimary,
            disabledContainerColor = DesdyTheme.colors.disabled,
            disabledContentColor = DesdyTheme.colors.onDisabled
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}

/**
 * Desdy filled tonal icon button.
 *
 * Use for medium-emphasis icon actions.
 */
@Composable
fun DesdyFilledTonalIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentDescription: String? = null
) {
    FilledTonalIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = IconButtonDefaults.filledTonalIconButtonColors(
            containerColor = DesdyTheme.colors.secondaryContainer,
            contentColor = DesdyTheme.colors.onSecondaryContainer,
            disabledContainerColor = DesdyTheme.colors.disabled,
            disabledContentColor = DesdyTheme.colors.onDisabled
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}

/**
 * Desdy outlined icon button.
 *
 * Use for medium-emphasis icon actions with outline.
 */
@Composable
fun DesdyOutlinedIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentDescription: String? = null
) {
    OutlinedIconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled) DesdyTheme.colors.outline else DesdyTheme.colors.disabled
        ),
        colors = IconButtonDefaults.outlinedIconButtonColors(
            contentColor = DesdyTheme.colors.onSurfaceVariant,
            disabledContentColor = DesdyTheme.colors.onDisabled
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp)
        )
    }
}

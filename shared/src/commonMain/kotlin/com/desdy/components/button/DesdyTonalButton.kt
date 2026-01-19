package com.desdy.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy tonal (secondary) button.
 *
 * Use for secondary actions with less emphasis than primary.
 *
 * @param onClick Called when button is clicked.
 * @param modifier Modifier for the button.
 * @param enabled Whether the button is enabled.
 * @param loading Whether to show loading indicator.
 * @param contentPadding Padding for button content.
 * @param content Button content.
 */
@Composable
fun DesdyTonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    contentPadding: PaddingValues = DesdyButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !loading,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = DesdyTheme.colors.secondaryContainer,
            contentColor = DesdyTheme.colors.onSecondaryContainer,
            disabledContainerColor = DesdyTheme.colors.disabled,
            disabledContentColor = DesdyTheme.colors.onDisabled
        ),
        shape = DesdyTheme.shapes.small,
        contentPadding = contentPadding
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp),
                color = DesdyTheme.colors.onSecondaryContainer,
                strokeWidth = 2.dp
            )
            Spacer(Modifier.width(DesdyTheme.spacing.small))
        }
        content()
    }
}

/**
 * Desdy tonal button with text.
 */
@Composable
fun DesdyTonalButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null
) {
    DesdyTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        loading = loading
    ) {
        leadingIcon?.let { icon ->
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(DesdyTheme.spacing.small))
        }
        Text(
            text = text,
            style = DesdyTheme.typography.labelLarge
        )
        trailingIcon?.let { icon ->
            Spacer(Modifier.width(DesdyTheme.spacing.small))
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

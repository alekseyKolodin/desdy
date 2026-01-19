package com.desdy.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy primary filled button.
 *
 * Use for primary actions that require attention.
 *
 * @param onClick Called when button is clicked.
 * @param modifier Modifier for the button.
 * @param enabled Whether the button is enabled.
 * @param loading Whether to show loading indicator.
 * @param contentPadding Padding for button content.
 * @param content Button content (typically text and/or icon).
 */
@Composable
fun DesdyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    contentPadding: PaddingValues = DesdyButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !loading,
        colors = ButtonDefaults.buttonColors(
            containerColor = DesdyTheme.colors.primary,
            contentColor = DesdyTheme.colors.onPrimary,
            disabledContainerColor = DesdyTheme.colors.disabled,
            disabledContentColor = DesdyTheme.colors.onDisabled
        ),
        shape = DesdyTheme.shapes.small,
        contentPadding = contentPadding
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp),
                color = DesdyTheme.colors.onPrimary,
                strokeWidth = 2.dp
            )
            Spacer(Modifier.width(DesdyTheme.spacing.small))
        }
        content()
    }
}

/**
 * Desdy primary filled button with text.
 *
 * Convenience overload for simple text buttons.
 *
 * @param text Button label text.
 * @param onClick Called when button is clicked.
 * @param modifier Modifier for the button.
 * @param enabled Whether the button is enabled.
 * @param loading Whether to show loading indicator.
 * @param leadingIcon Optional icon before text.
 * @param trailingIcon Optional icon after text.
 */
@Composable
fun DesdyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null
) {
    DesdyButton(
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

/**
 * Default values for DesdyButton.
 */
object DesdyButtonDefaults {
    val ContentPadding = PaddingValues(
        horizontal = 24.dp,
        vertical = 12.dp
    )

    val MinHeight = 48.dp
}

/**
 * Desdy destructive button for dangerous actions like delete.
 *
 * Uses error color scheme with high contrast.
 *
 * @param text Button label text.
 * @param onClick Called when button is clicked.
 * @param modifier Modifier for the button.
 * @param enabled Whether the button is enabled.
 * @param loading Whether to show loading indicator.
 */
@Composable
fun DesdyDestructiveButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !loading,
        colors = ButtonDefaults.buttonColors(
            containerColor = DesdyTheme.colors.error,
            contentColor = DesdyTheme.colors.onError,
            disabledContainerColor = DesdyTheme.colors.disabled,
            disabledContentColor = DesdyTheme.colors.onDisabled
        ),
        shape = DesdyTheme.shapes.small,
        contentPadding = DesdyButtonDefaults.ContentPadding
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp),
                color = DesdyTheme.colors.onError,
                strokeWidth = 2.dp
            )
            Spacer(Modifier.width(DesdyTheme.spacing.small))
        }
        Text(
            text = text,
            style = DesdyTheme.typography.labelLarge
        )
    }
}

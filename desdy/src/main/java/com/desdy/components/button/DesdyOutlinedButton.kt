package com.desdy.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy outlined button.
 *
 * Use for secondary actions with medium emphasis.
 *
 * @param onClick Called when button is clicked.
 * @param modifier Modifier for the button.
 * @param enabled Whether the button is enabled.
 * @param loading Whether to show loading indicator.
 * @param contentPadding Padding for button content.
 * @param content Button content.
 */
@Composable
fun DesdyOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    contentPadding: PaddingValues = DesdyButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !loading,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = DesdyTheme.colors.primary,
            disabledContentColor = DesdyTheme.colors.onDisabled
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled && !loading) {
                DesdyTheme.colors.outline
            } else {
                DesdyTheme.colors.disabled
            }
        ),
        shape = DesdyTheme.shapes.small,
        contentPadding = contentPadding
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp),
                color = DesdyTheme.colors.primary,
                strokeWidth = 2.dp
            )
            Spacer(Modifier.width(DesdyTheme.spacing.small))
        }
        content()
    }
}

/**
 * Desdy outlined button with text.
 */
@Composable
fun DesdyOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null
) {
    DesdyOutlinedButton(
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

@Preview(showBackground = true)
@Composable
private fun DesdyOutlinedButtonPreview() {
    DesdyTheme {
        DesdyOutlinedButton(
            text = "Outlined Button",
            onClick = { }
        )
    }
}

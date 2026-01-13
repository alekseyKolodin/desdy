package com.desdy.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy text button.
 *
 * Use for low-emphasis actions, typically in dialogs or inline.
 *
 * @param onClick Called when button is clicked.
 * @param modifier Modifier for the button.
 * @param enabled Whether the button is enabled.
 * @param loading Whether to show loading indicator.
 * @param contentPadding Padding for button content.
 * @param content Button content.
 */
@Composable
fun DesdyTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    contentPadding: PaddingValues = DesdyButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !loading,
        colors = ButtonDefaults.textButtonColors(
            contentColor = DesdyTheme.colors.primary,
            disabledContentColor = DesdyTheme.colors.onDisabled
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
 * Desdy text button with text.
 */
@Composable
fun DesdyTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null
) {
    DesdyTextButton(
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
private fun DesdyTextButtonPreview() {
    DesdyTheme {
        DesdyTextButton(
            text = "Text Button",
            onClick = { }
        )
    }
}

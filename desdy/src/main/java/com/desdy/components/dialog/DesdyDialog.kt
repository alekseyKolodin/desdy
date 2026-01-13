package com.desdy.components.dialog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.desdy.components.button.DesdyButton
import com.desdy.components.button.DesdyDestructiveButton
import com.desdy.components.button.DesdyTextButton
import com.desdy.theme.DesdyTheme

/**
 * Desdy alert dialog.
 *
 * @param onDismissRequest Called when dialog should be dismissed.
 * @param title Dialog title.
 * @param text Dialog message text.
 * @param confirmButton Confirm button composable.
 * @param dismissButton Optional dismiss button composable.
 * @param icon Optional icon.
 * @param modifier Modifier for the dialog.
 */
@Composable
fun DesdyAlertDialog(
    onDismissRequest: () -> Unit,
    title: String,
    text: String,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    icon: ImageVector? = null
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(title, style = DesdyTheme.typography.headlineSmall) },
        text = { Text(text, style = DesdyTheme.typography.bodyMedium) },
        confirmButton = confirmButton,
        modifier = modifier,
        dismissButton = dismissButton,
        icon = icon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = DesdyTheme.colors.primary
                )
            }
        },
        shape = DesdyTheme.shapes.extraLarge,
        containerColor = DesdyTheme.colors.surface,
        iconContentColor = DesdyTheme.colors.primary,
        titleContentColor = DesdyTheme.colors.onSurface,
        textContentColor = DesdyTheme.colors.onSurfaceVariant
    )
}

/**
 * Desdy confirmation dialog.
 *
 * Pre-configured dialog for confirmation actions.
 *
 * @param visible Whether the dialog is visible.
 * @param onConfirm Called when user confirms.
 * @param onDismiss Called when user dismisses.
 * @param title Dialog title.
 * @param message Dialog message.
 * @param confirmText Confirm button text.
 * @param dismissText Dismiss button text.
 * @param icon Optional icon.
 */
@Composable
fun DesdyConfirmDialog(
    visible: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    title: String,
    message: String,
    confirmText: String = "Confirm",
    dismissText: String = "Cancel",
    icon: ImageVector? = null
) {
    if (visible) {
        DesdyAlertDialog(
            onDismissRequest = onDismiss,
            title = title,
            text = message,
            icon = icon,
            confirmButton = {
                DesdyButton(
                    text = confirmText,
                    onClick = {
                        onConfirm()
                        onDismiss()
                    }
                )
            },
            dismissButton = {
                DesdyTextButton(
                    text = dismissText,
                    onClick = onDismiss
                )
            }
        )
    }
}

/**
 * Desdy destructive confirmation dialog.
 *
 * For dangerous actions like delete.
 */
@Composable
fun DesdyDestructiveDialog(
    visible: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    title: String,
    message: String,
    confirmText: String = "Delete",
    dismissText: String = "Cancel",
    icon: ImageVector? = null
) {
    if (visible) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(title, style = DesdyTheme.typography.headlineSmall) },
            text = { Text(message, style = DesdyTheme.typography.bodyMedium) },
            confirmButton = {
                DesdyDestructiveButton(
                    text = confirmText,
                    onClick = {
                        onConfirm()
                        onDismiss()
                    }
                )
            },
            dismissButton = {
                DesdyTextButton(
                    text = dismissText,
                    onClick = onDismiss
                )
            },
            icon = icon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        tint = DesdyTheme.colors.error
                    )
                }
            },
            shape = DesdyTheme.shapes.extraLarge,
            containerColor = DesdyTheme.colors.surface,
            iconContentColor = DesdyTheme.colors.error,
            titleContentColor = DesdyTheme.colors.onSurface,
            textContentColor = DesdyTheme.colors.onSurfaceVariant
        )
    }
}

@Preview
@Composable
private fun DesdyAlertDialogPreview() {
    DesdyTheme {
        DesdyAlertDialog(
            onDismissRequest = { },
            title = "Dialog Title",
            text = "This is the dialog message text.",
            confirmButton = {
                DesdyButton(text = "OK", onClick = { })
            },
            dismissButton = {
                DesdyTextButton(text = "Cancel", onClick = { })
            }
        )
    }
}

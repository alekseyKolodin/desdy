package com.example.desdy.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.desdy.components.button.DesdyButton
import com.desdy.components.button.DesdyDestructiveButton
import com.desdy.components.button.DesdyOutlinedButton
import com.desdy.components.dialog.DesdyAlertDialog
import com.desdy.components.dialog.DesdyConfirmDialog
import com.desdy.components.dialog.DesdyDestructiveDialog
import com.desdy.theme.DesdyTheme

/**
 * Showcase for dialog variants.
 */
@Composable
fun DialogsShowcase() {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showConfirmDialog by remember { mutableStateOf(false) }
    var showDestructiveDialog by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
        ) {
            DesdyButton(
                text = "Alert",
                onClick = { showAlertDialog = true }
            )

            DesdyOutlinedButton(
                text = "Confirm",
                onClick = { showConfirmDialog = true }
            )

            DesdyDestructiveButton(
                text = "Delete",
                onClick = { showDestructiveDialog = true }
            )
        }
    }

    // Alert Dialog
    if (showAlertDialog) {
        DesdyAlertDialog(
            onDismissRequest = { showAlertDialog = false },
            title = "Внимание",
            text = "Это информационное сообщение для пользователя.",
            confirmButton = {
                DesdyButton(
                    text = "Понятно",
                    onClick = { showAlertDialog = false }
                )
            }
        )
    }

    // Confirm Dialog
    DesdyConfirmDialog(
        visible = showConfirmDialog,
        onConfirm = { },
        onDismiss = { showConfirmDialog = false },
        title = "Подтверждение",
        message = "Вы уверены, что хотите продолжить?",
        confirmText = "Да",
        dismissText = "Отмена"
    )

    // Destructive Dialog
    DesdyDestructiveDialog(
        visible = showDestructiveDialog,
        onConfirm = { },
        onDismiss = { showDestructiveDialog = false },
        title = "Удаление",
        message = "Это действие нельзя отменить. Вы уверены?",
        confirmText = "Удалить",
        dismissText = "Отмена"
    )
}

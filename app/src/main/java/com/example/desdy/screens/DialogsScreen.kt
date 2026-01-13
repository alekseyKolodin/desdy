package com.example.desdy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.desdy.components.button.DesdyButton
import com.desdy.components.button.DesdyOutlinedButton
import com.desdy.components.dialog.*
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.theme.DesdyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogsScreen(onBack: () -> Unit) {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showConfirmDialog by remember { mutableStateOf(false) }
    var showDestructiveDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Dialogs") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(DesdyTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large)
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Alert Dialog")
                    BodySmall(text = "For important information", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyButton(
                        text = "Show Alert",
                        onClick = { showAlertDialog = true },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Confirmation Dialog")
                    BodySmall(text = "For user confirmations", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyOutlinedButton(
                        text = "Show Confirmation",
                        onClick = { showConfirmDialog = true },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Destructive Dialog")
                    BodySmall(text = "For dangerous actions", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyOutlinedButton(
                        text = "Show Destructive",
                        onClick = { showDestructiveDialog = true },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        // Alert Dialog
        if (showAlertDialog) {
            DesdyAlertDialog(
                onDismissRequest = { showAlertDialog = false },
                title = "Information",
                text = "This is an informational alert dialog. It displays important information to the user.",
                icon = Icons.Default.Info,
                confirmButton = {
                    DesdyButton(
                        text = "OK",
                        onClick = { showAlertDialog = false }
                    )
                }
            )
        }

        // Confirmation Dialog
        DesdyConfirmDialog(
            visible = showConfirmDialog,
            onConfirm = { /* Handle confirm */ },
            onDismiss = { showConfirmDialog = false },
            title = "Save Changes?",
            message = "You have unsaved changes. Would you like to save them before leaving?",
            confirmText = "Save",
            dismissText = "Discard",
            icon = Icons.Default.Warning
        )

        // Destructive Dialog
        DesdyDestructiveDialog(
            visible = showDestructiveDialog,
            onConfirm = { /* Handle delete */ },
            onDismiss = { showDestructiveDialog = false },
            title = "Delete Item?",
            message = "This action cannot be undone. Are you sure you want to delete this item?",
            confirmText = "Delete",
            dismissText = "Cancel",
            icon = Icons.Default.Delete
        )
    }
}

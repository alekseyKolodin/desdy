package com.example.desdy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
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
import com.desdy.components.button.*
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.theme.DesdyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonsScreen(onBack: () -> Unit) {
    var loading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Buttons") },
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
                    HeadlineSmall(text = "Filled Button")
                    BodySmall(text = "Primary action button", color = DesdyTheme.colors.onSurfaceVariant)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        DesdyButton(text = "Enabled", onClick = { })
                        DesdyButton(text = "Disabled", onClick = { }, enabled = false)
                    }
                    DesdyButton(
                        text = "With Icon",
                        onClick = { },
                        leadingIcon = Icons.AutoMirrored.Filled.Send
                    )
                    DesdyButton(
                        text = "Loading",
                        onClick = { },
                        loading = true
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Tonal Button")
                    BodySmall(text = "Secondary action button", color = DesdyTheme.colors.onSurfaceVariant)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        DesdyTonalButton(text = "Enabled", onClick = { })
                        DesdyTonalButton(text = "Disabled", onClick = { }, enabled = false)
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Outlined Button")
                    BodySmall(text = "Medium emphasis button", color = DesdyTheme.colors.onSurfaceVariant)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        DesdyOutlinedButton(text = "Enabled", onClick = { })
                        DesdyOutlinedButton(text = "Disabled", onClick = { }, enabled = false)
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Text Button")
                    BodySmall(text = "Low emphasis button", color = DesdyTheme.colors.onSurfaceVariant)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        DesdyTextButton(text = "Enabled", onClick = { })
                        DesdyTextButton(text = "Disabled", onClick = { }, enabled = false)
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Icon Buttons")
                    BodySmall(text = "Various icon button styles", color = DesdyTheme.colors.onSurfaceVariant)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        DesdyIconButton(icon = Icons.Default.Favorite, onClick = { })
                        DesdyFilledIconButton(icon = Icons.Default.Add, onClick = { })
                        DesdyFilledTonalIconButton(icon = Icons.Default.Favorite, onClick = { })
                        DesdyOutlinedIconButton(icon = Icons.Default.Add, onClick = { })
                    }
                }
            }
        }
    }
}

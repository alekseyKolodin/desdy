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
import com.desdy.components.card.DesdyCard
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.selection.*
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.theme.DesdyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionScreen(onBack: () -> Unit) {
    var checkbox1 by remember { mutableStateOf(true) }
    var checkbox2 by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Option 1") }
    var switch1 by remember { mutableStateOf(true) }
    var switch2 by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Selection Controls") },
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
                    HeadlineSmall(text = "Checkboxes")
                    BodySmall(text = "For multiple selections", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyCard(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(DesdyTheme.spacing.small)) {
                            DesdyLabeledCheckbox(
                                checked = checkbox1,
                                onCheckedChange = { checkbox1 = it },
                                label = "Accept terms and conditions"
                            )
                            DesdyLabeledCheckbox(
                                checked = checkbox2,
                                onCheckedChange = { checkbox2 = it },
                                label = "Subscribe to newsletter"
                            )
                            DesdyLabeledCheckbox(
                                checked = false,
                                onCheckedChange = { },
                                label = "Disabled option",
                                enabled = false
                            )
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Radio Buttons")
                    BodySmall(text = "For single selection from a group", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyCard(modifier = Modifier.fillMaxWidth()) {
                        DesdyRadioGroup(
                            options = listOf("Option 1", "Option 2", "Option 3"),
                            selected = selectedOption,
                            onSelectedChange = { selectedOption = it },
                            modifier = Modifier.padding(DesdyTheme.spacing.small)
                        )
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Switches")
                    BodySmall(text = "For on/off toggles", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyCard(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(DesdyTheme.spacing.small)) {
                            DesdyLabeledSwitch(
                                checked = switch1,
                                onCheckedChange = { switch1 = it },
                                label = "Enable notifications"
                            )
                            DesdyLabeledSwitch(
                                checked = switch2,
                                onCheckedChange = { switch2 = it },
                                label = "Dark mode"
                            )
                            DesdyLabeledSwitch(
                                checked = true,
                                onCheckedChange = { },
                                label = "Disabled switch",
                                enabled = false
                            )
                        }
                    }
                }
            }
        }
    }
}

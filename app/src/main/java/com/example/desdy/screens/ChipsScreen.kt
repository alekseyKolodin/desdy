package com.example.desdy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.desdy.components.chip.*
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.theme.DesdyTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ChipsScreen(onBack: () -> Unit) {
    val filters = remember { mutableStateListOf("All", "Active", "Completed") }
    var selectedFilter by remember { mutableStateOf("All") }
    val tags = remember { mutableStateListOf("Design", "Android", "Compose", "Kotlin") }

    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Chips") },
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
                    HeadlineSmall(text = "Filter Chips")
                    BodySmall(text = "For filtering content", color = DesdyTheme.colors.onSurfaceVariant)
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        filters.forEach { filter ->
                            DesdyFilterChip(
                                label = filter,
                                selected = selectedFilter == filter,
                                onClick = { selectedFilter = filter }
                            )
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Input Chips")
                    BodySmall(text = "Removable tags or selections", color = DesdyTheme.colors.onSurfaceVariant)
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        tags.forEach { tag ->
                            DesdyInputChip(
                                label = tag,
                                selected = false,
                                onClick = { },
                                onRemove = { tags.remove(tag) }
                            )
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Assist Chips")
                    BodySmall(text = "Smart actions or suggestions", color = DesdyTheme.colors.onSurfaceVariant)
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        DesdyAssistChip(
                            label = "Add to favorites",
                            onClick = { },
                            leadingIcon = Icons.Default.Star
                        )
                        DesdyAssistChip(
                            label = "Mark as done",
                            onClick = { },
                            leadingIcon = Icons.Default.Done
                        )
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Suggestion Chips")
                    BodySmall(text = "Dynamically generated suggestions", color = DesdyTheme.colors.onSurfaceVariant)
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
                    ) {
                        listOf("Material Design", "Jetpack Compose", "UI Components").forEach { suggestion ->
                            DesdySuggestionChip(
                                label = suggestion,
                                onClick = { }
                            )
                        }
                    }
                }
            }
        }
    }
}

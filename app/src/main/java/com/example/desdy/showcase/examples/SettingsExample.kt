package com.example.desdy.showcase.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.desdy.components.divider.DesdyDivider
import com.desdy.components.list.DesdyClickableListItem
import com.desdy.components.list.DesdyListItem
import com.desdy.components.selection.DesdySwitch
import com.desdy.components.text.BodyLarge
import com.desdy.components.text.BodySmall
import com.desdy.components.text.LabelMedium
import com.desdy.components.text.TitleMedium
import com.desdy.theme.DesdyTheme

/**
 * Settings example screen.
 */
@Composable
fun SettingsExample() {
    var notifications by remember { mutableStateOf(true) }
    var darkTheme by remember { mutableStateOf(false) }
    val language by remember { mutableStateOf("Русский") }

    LazyColumn {
        item {
            // Profile section
            DesdyClickableListItem(
                headlineContent = { TitleMedium(text = "Иван Петров") },
                supportingContent = {
                    BodySmall(
                        text = "ivan@example.com",
                        color = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                leadingContent = {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                DesdyTheme.colors.primaryContainer,
                                DesdyTheme.shapes.full
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        TitleMedium(
                            text = "ИП",
                            color = DesdyTheme.colors.primary
                        )
                    }
                },
                trailingContent = {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                onClick = {}
            )
        }

        item { DesdyDivider() }

        item {
            LabelMedium(
                text = "Основные",
                color = DesdyTheme.colors.onSurfaceVariant,
                modifier = Modifier.padding(DesdyTheme.spacing.medium)
            )
        }

        item {
            DesdyListItem(
                headlineContent = { BodyLarge(text = "Уведомления") },
                supportingContent = {
                    BodySmall(
                        text = "Push и email оповещения",
                        color = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                leadingContent = {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = null,
                        tint = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                trailingContent = {
                    DesdySwitch(
                        checked = notifications,
                        onCheckedChange = { notifications = it }
                    )
                }
            )
        }

        item {
            DesdyListItem(
                headlineContent = { BodyLarge(text = "Тёмная тема") },
                leadingContent = {
                    Icon(
                        Icons.Default.DarkMode,
                        contentDescription = null,
                        tint = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                trailingContent = {
                    DesdySwitch(
                        checked = darkTheme,
                        onCheckedChange = { darkTheme = it }
                    )
                }
            )
        }

        item {
            DesdyClickableListItem(
                headlineContent = { BodyLarge(text = "Язык") },
                supportingContent = {
                    BodySmall(
                        text = language,
                        color = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                leadingContent = {
                    Icon(
                        Icons.Default.Language,
                        contentDescription = null,
                        tint = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                trailingContent = {
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                onClick = {}
            )
        }

        item { DesdyDivider() }

        item {
            LabelMedium(
                text = "О приложении",
                color = DesdyTheme.colors.onSurfaceVariant,
                modifier = Modifier.padding(DesdyTheme.spacing.medium)
            )
        }

        item {
            DesdyClickableListItem(
                headlineContent = { BodyLarge(text = "Версия") },
                supportingContent = {
                    BodySmall(
                        text = "1.0.0 (build 42)",
                        color = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                leadingContent = {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = null,
                        tint = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                onClick = {}
            )
        }
    }
}

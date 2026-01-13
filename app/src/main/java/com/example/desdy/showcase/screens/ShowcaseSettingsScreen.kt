package com.example.desdy.showcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.desdy.components.card.DesdyOutlinedCard
import com.desdy.components.list.DesdyListItem
import com.desdy.components.selection.DesdySwitch
import com.desdy.components.text.BodyMedium
import com.desdy.components.text.BodySmall
import com.desdy.components.text.HeadlineMedium
import com.desdy.components.text.TitleMedium
import com.desdy.theme.DesdyTheme

/**
 * Settings screen for the showcase app.
 */
@Composable
fun ShowcaseSettingsScreen(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(DesdyTheme.spacing.medium)
    ) {
        HeadlineMedium(text = "Настройки")

        Spacer(Modifier.height(DesdyTheme.spacing.large))

        DesdyOutlinedCard {
            DesdyListItem(
                headlineContent = { TitleMedium(text = "Тёмная тема") },
                supportingContent = {
                    BodySmall(
                        text = "Переключение между светлой и тёмной темой",
                        color = DesdyTheme.colors.onSurfaceVariant
                    )
                },
                trailingContent = {
                    DesdySwitch(
                        checked = isDarkTheme,
                        onCheckedChange = onThemeChange
                    )
                }
            )
        }

        Spacer(Modifier.height(DesdyTheme.spacing.medium))

        DesdyOutlinedCard {
            Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                TitleMedium(text = "О дизайн-системе")
                Spacer(Modifier.height(DesdyTheme.spacing.small))
                BodyMedium(text = "Desdy Design System")
                BodySmall(
                    text = "Версия 1.0.0",
                    color = DesdyTheme.colors.onSurfaceVariant
                )
                Spacer(Modifier.height(DesdyTheme.spacing.small))
                BodySmall(
                    text = "Современная дизайн-система на Jetpack Compose",
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            }
        }
    }
}

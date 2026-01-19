package com.example.desdy.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.desdy.components.divider.DesdyDivider
import com.desdy.components.list.DesdyClickableListItem
import com.desdy.components.list.DesdyListItem
import com.desdy.components.text.BodyLarge
import com.desdy.components.text.BodySmall
import com.desdy.theme.DesdyTheme

/**
 * Showcase for list items.
 */
@Composable
fun ListsShowcase() {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
    ) {
        DesdyListItem(
            headlineContent = { BodyLarge(text = "Простой элемент списка") },
            supportingContent = {
                BodySmall(
                    text = "Вспомогательный текст",
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            },
            leadingContent = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    tint = DesdyTheme.colors.onSurfaceVariant
                )
            }
        )

        DesdyDivider()

        DesdyClickableListItem(
            headlineContent = { BodyLarge(text = "Кликабельный элемент") },
            supportingContent = {
                BodySmall(
                    text = "Нажмите для перехода",
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            },
            leadingContent = {
                Icon(
                    Icons.Default.Settings,
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

        DesdyDivider()

        DesdyListItem(
            headlineContent = { BodyLarge(text = "Элемент с иконкой справа") },
            trailingContent = {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    tint = DesdyTheme.colors.error
                )
            }
        )
    }
}

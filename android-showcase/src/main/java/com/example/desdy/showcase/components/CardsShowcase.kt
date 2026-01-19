package com.example.desdy.showcase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.desdy.components.card.DesdyCard
import com.desdy.components.card.DesdyElevatedCard
import com.desdy.components.card.DesdyOutlinedCard
import com.desdy.components.text.BodyMedium
import com.desdy.components.text.BodySmall
import com.desdy.components.text.TitleMedium
import com.desdy.theme.DesdyTheme

/**
 * Showcase for card variants.
 */
@Composable
fun CardsShowcase() {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        // Filled Card
        DesdyCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                TitleMedium(text = "Filled Card")
                Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
                BodyMedium(
                    text = "Стандартная карточка для группировки контента",
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            }
        }

        // Elevated Card
        DesdyElevatedCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                TitleMedium(text = "Elevated Card")
                Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
                BodyMedium(
                    text = "Карточка с тенью для выделения важного контента",
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            }
        }

        // Outlined Card
        DesdyOutlinedCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                TitleMedium(text = "Outlined Card")
                Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
                BodyMedium(
                    text = "Карточка с рамкой для нейтрального контента",
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            }
        }

        // Clickable Card Example
        DesdyCard(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(DesdyTheme.spacing.medium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            DesdyTheme.colors.primaryContainer,
                            DesdyTheme.shapes.medium
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = null,
                        tint = DesdyTheme.colors.primary
                    )
                }
                Spacer(Modifier.width(DesdyTheme.spacing.medium))
                Column(modifier = Modifier.weight(1f)) {
                    TitleMedium(text = "Кликабельная карточка")
                    BodySmall(
                        text = "Нажмите для перехода",
                        color = DesdyTheme.colors.onSurfaceVariant
                    )
                }
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = DesdyTheme.colors.onSurfaceVariant
                )
            }
        }
    }
}

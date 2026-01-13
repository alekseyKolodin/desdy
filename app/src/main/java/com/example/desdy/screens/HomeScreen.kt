package com.example.desdy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.NightsStay
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.desdy.components.button.DesdyIconButton
import com.desdy.components.card.DesdyCard
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.HeadlineMedium
import com.desdy.components.text.TitleMedium
import com.desdy.components.text.BodySmall
import com.desdy.theme.DesdyTheme
import com.example.desdy.navigation.CatalogRoute

data class CatalogItem(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val route: String
)

private val catalogItems = listOf(
    CatalogItem(
        title = "Colors",
        description = "Color palette and semantic colors",
        icon = Icons.Default.Palette,
        route = CatalogRoute.Colors.route
    ),
    CatalogItem(
        title = "Typography",
        description = "Text styles and typography scale",
        icon = Icons.Default.TextFields,
        route = CatalogRoute.Typography.route
    ),
    CatalogItem(
        title = "Buttons",
        description = "Button variants and states",
        icon = Icons.Default.TouchApp,
        route = CatalogRoute.Buttons.route
    ),
    CatalogItem(
        title = "Text Inputs",
        description = "Text fields and input components",
        icon = Icons.Default.Edit,
        route = CatalogRoute.Inputs.route
    ),
    CatalogItem(
        title = "Selection Controls",
        description = "Checkboxes, radios, and switches",
        icon = Icons.Default.CheckBox,
        route = CatalogRoute.Selection.route
    ),
    CatalogItem(
        title = "Cards",
        description = "Card variants and elevations",
        icon = Icons.Default.CreditCard,
        route = CatalogRoute.Cards.route
    ),
    CatalogItem(
        title = "Chips",
        description = "Filter, input, and suggestion chips",
        icon = Icons.Default.Sell,
        route = CatalogRoute.Chips.route
    ),
    CatalogItem(
        title = "Progress",
        description = "Progress indicators and loaders",
        icon = Icons.Default.Refresh,
        route = CatalogRoute.Progress.route
    ),
    CatalogItem(
        title = "Dialogs",
        description = "Alert and confirmation dialogs",
        icon = Icons.Default.Info,
        route = CatalogRoute.Dialogs.route
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit,
    onThemeToggle: () -> Unit,
    isDarkTheme: Boolean
) {
    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Desdy",
                            style = DesdyTheme.typography.titleLarge
                        )
                        Text(
                            text = "Design System",
                            style = DesdyTheme.typography.bodySmall,
                            color = DesdyTheme.colors.onSurfaceVariant
                        )
                    }
                },
                actions = {
                    DesdyIconButton(
                        icon = if (isDarkTheme) Icons.Default.WbSunny else Icons.Default.NightsStay,
                        onClick = onThemeToggle,
                        contentDescription = "Toggle theme"
                    )
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(DesdyTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
        ) {
            item {
                HeadlineMedium(
                    text = "Components",
                    modifier = Modifier.padding(vertical = DesdyTheme.spacing.small)
                )
            }

            items(catalogItems) { item ->
                CatalogItemCard(
                    item = item,
                    onClick = { onNavigate(item.route) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(DesdyTheme.spacing.large))
            }
        }
    }
}

@Composable
private fun CatalogItemCard(
    item: CatalogItem,
    onClick: () -> Unit
) {
    DesdyCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DesdyTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = DesdyTheme.colors.primary
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = DesdyTheme.spacing.medium)
            ) {
                TitleMedium(text = item.title)
                BodySmall(
                    text = item.description,
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Go",
                tint = DesdyTheme.colors.onSurfaceVariant
            )
        }
    }
}

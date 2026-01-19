package com.example.desdy.showcase.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.desdy.components.card.DesdyCard
import com.desdy.components.text.HeadlineMedium
import com.desdy.components.text.TitleMedium
import com.desdy.theme.DesdyTheme
import com.example.desdy.showcase.components.ButtonsShowcase
import com.example.desdy.showcase.components.CardsShowcase
import com.example.desdy.showcase.components.ChipsShowcase
import com.example.desdy.showcase.components.ProgressShowcase
import com.example.desdy.showcase.components.SelectionShowcase
import com.example.desdy.showcase.components.TextFieldsShowcase
import com.example.desdy.showcase.components.ListsShowcase
import com.example.desdy.showcase.components.DialogsShowcase
import com.example.desdy.showcase.components.SoulSyncShowcase

/**
 * Component types for the showcase.
 */
enum class ComponentType {
    SOULSYNC,
    BUTTONS,
    TEXT_FIELDS,
    SELECTION,
    CHIPS,
    CARDS,
    DIALOGS,
    PROGRESS,
    LISTS
}

/**
 * Data class for component sections.
 */
data class ComponentSection(
    val title: String,
    val type: ComponentType
)

/**
 * Screen displaying all Desdy components in expandable sections.
 */
@Composable
fun ComponentsScreen() {
    val sections = listOf(
        ComponentSection("SoulSync", ComponentType.SOULSYNC),
        ComponentSection("Кнопки", ComponentType.BUTTONS),
        ComponentSection("Текстовые поля", ComponentType.TEXT_FIELDS),
        ComponentSection("Выбор", ComponentType.SELECTION),
        ComponentSection("Чипы", ComponentType.CHIPS),
        ComponentSection("Карточки", ComponentType.CARDS),
        ComponentSection("Диалоги", ComponentType.DIALOGS),
        ComponentSection("Прогресс", ComponentType.PROGRESS),
        ComponentSection("Списки", ComponentType.LISTS)
    )

    LazyColumn(
        contentPadding = PaddingValues(DesdyTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
    ) {
        item {
            HeadlineMedium(
                text = "Компоненты",
                modifier = Modifier.padding(bottom = DesdyTheme.spacing.medium)
            )
        }

        items(sections) { section ->
            ExpandableComponentCard(section)
        }
    }
}

/**
 * Expandable card for a component section.
 */
@Composable
fun ExpandableComponentCard(section: ComponentSection) {
    var expanded by remember { mutableStateOf(false) }

    DesdyCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(DesdyTheme.spacing.medium),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TitleMedium(text = section.title)
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = if (expanded) "Свернуть" else "Развернуть",
                    tint = DesdyTheme.colors.onSurfaceVariant
                )
            }

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = DesdyTheme.spacing.medium,
                        end = DesdyTheme.spacing.medium,
                        bottom = DesdyTheme.spacing.medium
                    )
                ) {
                    when (section.type) {
                        ComponentType.SOULSYNC -> SoulSyncShowcase()
                        ComponentType.BUTTONS -> ButtonsShowcase()
                        ComponentType.TEXT_FIELDS -> TextFieldsShowcase()
                        ComponentType.SELECTION -> SelectionShowcase()
                        ComponentType.CHIPS -> ChipsShowcase()
                        ComponentType.CARDS -> CardsShowcase()
                        ComponentType.DIALOGS -> DialogsShowcase()
                        ComponentType.PROGRESS -> ProgressShowcase()
                        ComponentType.LISTS -> ListsShowcase()
                    }
                }
            }
        }
    }
}

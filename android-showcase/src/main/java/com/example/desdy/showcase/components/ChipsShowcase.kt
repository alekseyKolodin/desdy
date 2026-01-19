package com.example.desdy.showcase.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.desdy.components.chip.DesdyAssistChip
import com.desdy.components.chip.DesdyFilterChip
import com.desdy.components.chip.DesdyInputChip
import com.desdy.components.chip.DesdySuggestionChip
import com.desdy.components.text.LabelMedium
import com.desdy.theme.DesdyTheme

/**
 * Showcase for chip variants.
 */
@Composable
fun ChipsShowcase() {
    var filter1 by remember { mutableStateOf(false) }
    var filter2 by remember { mutableStateOf(true) }
    var filter3 by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        LabelMedium(
            text = "Filter Chips",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdyFilterChip(
                label = "Все",
                selected = filter1,
                onClick = { filter1 = !filter1 }
            )
            DesdyFilterChip(
                label = "Новые",
                selected = filter2,
                onClick = { filter2 = !filter2 }
            )
            DesdyFilterChip(
                label = "Популярные",
                selected = filter3,
                onClick = { filter3 = !filter3 }
            )
        }

        LabelMedium(
            text = "Input Chips",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdyInputChip(
                label = "Kotlin",
                selected = false,
                onClick = {},
                onRemove = {}
            )
            DesdyInputChip(
                label = "Compose",
                selected = true,
                onClick = {},
                onRemove = {}
            )
            DesdyInputChip(
                label = "Android",
                selected = false,
                onClick = {},
                onRemove = {}
            )
        }

        LabelMedium(
            text = "Assist Chips",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdyAssistChip(
                label = "Добавить событие",
                onClick = {},
                leadingIcon = Icons.Default.Add
            )
            DesdyAssistChip(
                label = "Поделиться",
                onClick = {},
                leadingIcon = Icons.Default.Share
            )
        }

        LabelMedium(
            text = "Suggestion Chips",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdySuggestionChip(label = "Рядом со мной", onClick = {})
            DesdySuggestionChip(label = "Открыто сейчас", onClick = {})
            DesdySuggestionChip(label = "До 500 руб.", onClick = {})
        }
    }
}

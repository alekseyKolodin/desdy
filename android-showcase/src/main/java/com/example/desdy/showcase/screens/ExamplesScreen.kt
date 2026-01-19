package com.example.desdy.showcase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.desdy.components.tabs.DesdyTab
import com.desdy.components.tabs.DesdyTabRow
import com.example.desdy.showcase.examples.ChatExample
import com.example.desdy.showcase.examples.LoginExample
import com.example.desdy.showcase.examples.ProductCardExample
import com.example.desdy.showcase.examples.SettingsExample

/**
 * Screen with realistic UI examples.
 */
@Composable
fun ExamplesScreen() {
    var selectedExample by remember { mutableIntStateOf(0) }
    val examples = listOf("Чат", "Карточка", "Логин", "Настройки")

    Column {
        // Tabs
        DesdyTabRow(selectedTabIndex = selectedExample) {
            examples.forEachIndexed { index, title ->
                DesdyTab(
                    selected = selectedExample == index,
                    onClick = { selectedExample = index },
                    text = { Text(title) }
                )
            }
        }

        // Content
        when (selectedExample) {
            0 -> ChatExample()
            1 -> ProductCardExample()
            2 -> LoginExample()
            3 -> SettingsExample()
        }
    }
}

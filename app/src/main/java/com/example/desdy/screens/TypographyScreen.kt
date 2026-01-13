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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.*
import com.desdy.theme.DesdyTheme

data class TypographyItem(
    val name: String,
    val style: @Composable () -> TextStyle,
    val sample: String = "The quick brown fox"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypographyScreen(onBack: () -> Unit) {
    val typographyItems = listOf(
        TypographyItem("Display Large", { DesdyTheme.typography.displayLarge }, "Aa"),
        TypographyItem("Display Medium", { DesdyTheme.typography.displayMedium }, "Aa"),
        TypographyItem("Display Small", { DesdyTheme.typography.displaySmall }, "Aa"),
        TypographyItem("Headline Large", { DesdyTheme.typography.headlineLarge }),
        TypographyItem("Headline Medium", { DesdyTheme.typography.headlineMedium }),
        TypographyItem("Headline Small", { DesdyTheme.typography.headlineSmall }),
        TypographyItem("Title Large", { DesdyTheme.typography.titleLarge }),
        TypographyItem("Title Medium", { DesdyTheme.typography.titleMedium }),
        TypographyItem("Title Small", { DesdyTheme.typography.titleSmall }),
        TypographyItem("Body Large", { DesdyTheme.typography.bodyLarge }),
        TypographyItem("Body Medium", { DesdyTheme.typography.bodyMedium }),
        TypographyItem("Body Small", { DesdyTheme.typography.bodySmall }),
        TypographyItem("Label Large", { DesdyTheme.typography.labelLarge }),
        TypographyItem("Label Medium", { DesdyTheme.typography.labelMedium }),
        TypographyItem("Label Small", { DesdyTheme.typography.labelSmall })
    )

    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Typography") },
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
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
        ) {
            items(typographyItems.size) { index ->
                val item = typographyItems[index]
                TypographyRow(item)
                if (index < typographyItems.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = DesdyTheme.spacing.small),
                        color = DesdyTheme.colors.divider
                    )
                }
            }
        }
    }
}

@Composable
private fun TypographyRow(item: TypographyItem) {
    val style = item.style()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LabelSmall(
            text = item.name,
            color = DesdyTheme.colors.primary
        )
        Text(
            text = item.sample,
            style = style,
            color = DesdyTheme.colors.onSurface
        )
        BodySmall(
            text = "Size: ${style.fontSize}, Weight: ${style.fontWeight}, Line: ${style.lineHeight}",
            color = DesdyTheme.colors.onSurfaceVariant
        )
    }
}

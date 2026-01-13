package com.example.desdy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.components.text.LabelMedium
import com.desdy.theme.DesdyTheme

data class ColorItem(
    val name: String,
    val color: @Composable () -> Color,
    val onColor: @Composable () -> Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorsScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Colors") },
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
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
        ) {
            item {
                HeadlineSmall(text = "Primary")
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("primary", { DesdyTheme.colors.primary }, { DesdyTheme.colors.onPrimary }),
                        ColorItem("onPrimary", { DesdyTheme.colors.onPrimary }, { DesdyTheme.colors.primary })
                    )
                )
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("primaryContainer", { DesdyTheme.colors.primaryContainer }, { DesdyTheme.colors.onPrimaryContainer }),
                        ColorItem("onPrimaryContainer", { DesdyTheme.colors.onPrimaryContainer }, { DesdyTheme.colors.primaryContainer })
                    )
                )
            }

            item {
                HeadlineSmall(text = "Secondary")
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("secondary", { DesdyTheme.colors.secondary }, { DesdyTheme.colors.onSecondary }),
                        ColorItem("onSecondary", { DesdyTheme.colors.onSecondary }, { DesdyTheme.colors.secondary })
                    )
                )
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("secondaryContainer", { DesdyTheme.colors.secondaryContainer }, { DesdyTheme.colors.onSecondaryContainer }),
                        ColorItem("onSecondaryContainer", { DesdyTheme.colors.onSecondaryContainer }, { DesdyTheme.colors.secondaryContainer })
                    )
                )
            }

            item {
                HeadlineSmall(text = "Tertiary")
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("tertiary", { DesdyTheme.colors.tertiary }, { DesdyTheme.colors.onTertiary }),
                        ColorItem("onTertiary", { DesdyTheme.colors.onTertiary }, { DesdyTheme.colors.tertiary })
                    )
                )
            }

            item {
                HeadlineSmall(text = "Surface")
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("surface", { DesdyTheme.colors.surface }, { DesdyTheme.colors.onSurface }),
                        ColorItem("onSurface", { DesdyTheme.colors.onSurface }, { DesdyTheme.colors.surface })
                    )
                )
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("background", { DesdyTheme.colors.background }, { DesdyTheme.colors.onBackground }),
                        ColorItem("onBackground", { DesdyTheme.colors.onBackground }, { DesdyTheme.colors.background })
                    )
                )
            }

            item {
                HeadlineSmall(text = "Status")
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("error", { DesdyTheme.colors.error }, { DesdyTheme.colors.onError }),
                        ColorItem("success", { DesdyTheme.colors.success }, { DesdyTheme.colors.onSuccess })
                    )
                )
            }
            item {
                ColorRow(
                    listOf(
                        ColorItem("warning", { DesdyTheme.colors.warning }, { DesdyTheme.colors.onWarning }),
                        ColorItem("info", { DesdyTheme.colors.info }, { DesdyTheme.colors.onInfo })
                    )
                )
            }
        }
    }
}

@Composable
private fun ColorRow(colors: List<ColorItem>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
    ) {
        colors.forEach { item ->
            ColorSwatch(
                item = item,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ColorSwatch(
    item: ColorItem,
    modifier: Modifier = Modifier
) {
    val color = item.color()
    val onColor = item.onColor()

    Box(
        modifier = modifier
            .height(80.dp)
            .background(color, DesdyTheme.shapes.small),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LabelMedium(
                text = item.name,
                color = onColor
            )
            BodySmall(
                text = color.toHexString(),
                color = onColor.copy(alpha = 0.7f)
            )
        }
    }
}

private fun Color.toHexString(): String {
    val red = (this.red * 255).toInt()
    val green = (this.green * 255).toInt()
    val blue = (this.blue * 255).toInt()
    return String.format("#%02X%02X%02X", red, green, blue)
}

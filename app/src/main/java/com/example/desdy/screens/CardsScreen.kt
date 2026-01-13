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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.desdy.components.card.*
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.components.text.BodyMedium
import com.desdy.components.text.TitleMedium
import com.desdy.theme.DesdyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Cards") },
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
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large)
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Filled Card")
                    BodySmall(text = "Default card with surface color", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyCard(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                            TitleMedium(text = "Card Title")
                            BodyMedium(
                                text = "This is a filled card with some content. Cards are used to group related information.",
                                color = DesdyTheme.colors.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Elevated Card")
                    BodySmall(text = "Card with shadow elevation", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyElevatedCard(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                            TitleMedium(text = "Elevated Card")
                            BodyMedium(
                                text = "This card has elevation, creating a shadow effect that lifts it from the surface.",
                                color = DesdyTheme.colors.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Outlined Card")
                    BodySmall(text = "Card with border outline", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyOutlinedCard(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                            TitleMedium(text = "Outlined Card")
                            BodyMedium(
                                text = "This card has an outline border instead of elevation or fill.",
                                color = DesdyTheme.colors.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Clickable Card")
                    BodySmall(text = "Interactive card with click handling", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyCard(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
                            TitleMedium(text = "Tap Me!")
                            BodyMedium(
                                text = "This card is clickable and shows a ripple effect when pressed.",
                                color = DesdyTheme.colors.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

package com.example.desdy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.progress.*
import com.desdy.components.slider.DesdyLabeledSlider
import com.desdy.components.slider.DesdySlider
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.components.text.LabelMedium
import com.desdy.theme.DesdyTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressScreen(onBack: () -> Unit) {
    var sliderValue by remember { mutableFloatStateOf(50f) }

    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Progress & Sliders") },
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
                    HeadlineSmall(text = "Linear Progress")
                    BodySmall(text = "Determinate and indeterminate", color = DesdyTheme.colors.onSurfaceVariant)

                    LabelMedium(text = "Determinate (50%)")
                    DesdyLinearProgressIndicator(
                        progress = { 0.5f },
                        modifier = Modifier.fillMaxWidth()
                    )

                    LabelMedium(text = "Indeterminate")
                    DesdyLinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Circular Progress")
                    BodySmall(text = "Different sizes", color = DesdyTheme.colors.onSurfaceVariant)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DesdySmallCircularProgress()
                            LabelMedium(text = "Small")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DesdyMediumCircularProgress()
                            LabelMedium(text = "Medium")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DesdyLargeCircularProgress()
                            LabelMedium(text = "Large")
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Determinate Circular")
                    BodySmall(text = "Shows specific progress", color = DesdyTheme.colors.onSurfaceVariant)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DesdyCircularProgressIndicator(progress = { 0.25f })
                            LabelMedium(text = "25%")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DesdyCircularProgressIndicator(progress = { 0.5f })
                            LabelMedium(text = "50%")
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            DesdyCircularProgressIndicator(progress = { 0.75f })
                            LabelMedium(text = "75%")
                        }
                    }
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Slider")
                    BodySmall(text = "Select value from range", color = DesdyTheme.colors.onSurfaceVariant)

                    DesdySlider(
                        value = sliderValue / 100f,
                        onValueChange = { sliderValue = it * 100f }
                    )

                    DesdyLabeledSlider(
                        value = sliderValue,
                        onValueChange = { sliderValue = it },
                        label = "Volume",
                        valueLabel = { "${it.toInt()}%" }
                    )
                }
            }
        }
    }
}

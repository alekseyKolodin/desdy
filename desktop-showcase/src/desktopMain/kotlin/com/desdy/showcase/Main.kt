package com.desdy.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import com.desdy.components.button.DesdyButton
import com.desdy.components.button.DesdyIconButton
import com.desdy.components.button.DesdyOutlinedButton
import com.desdy.components.button.DesdyTextButton
import com.desdy.components.button.DesdyTonalButton
import com.desdy.components.card.CheckInCard
import com.desdy.components.card.DesdyCard
import com.desdy.components.card.InsightCard
import com.desdy.components.counter.StreakCounter
import com.desdy.components.counter.StreakCounterCard
import com.desdy.components.gauge.CompactTemperatureGauge
import com.desdy.components.gauge.TemperatureGauge
import com.desdy.components.progress.DotProgressBar
import com.desdy.components.progress.StepProgressBar
import com.desdy.components.selector.EmojiSelector
import com.desdy.components.selector.MoodSelector
import com.desdy.components.text.BodyLarge
import com.desdy.components.text.HeadlineLarge
import com.desdy.components.text.HeadlineMedium
import com.desdy.components.text.LabelLarge
import com.desdy.components.text.TitleLarge
import com.desdy.theme.DesdyTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Desdy Design System Showcase",
        state = WindowState(size = DpSize(1200.dp, 800.dp))
    ) {
        DesktopShowcaseApp()
    }
}

@Composable
fun DesktopShowcaseApp() {
    var isDarkTheme by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableIntStateOf(0) }

    DesdyTheme(darkTheme = isDarkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = DesdyTheme.colors.background
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                // Navigation Rail
                NavigationRail(
                    containerColor = DesdyTheme.colors.surface,
                    contentColor = DesdyTheme.colors.onSurface
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    NavigationRailItem(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        icon = { Icon(Icons.Default.Widgets, contentDescription = null) },
                        label = { Text("SoulSync") }
                    )

                    NavigationRailItem(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        icon = { Icon(Icons.Default.Palette, contentDescription = null) },
                        label = { Text("Components") }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Theme toggle
                    DesdyIconButton(
                        onClick = { isDarkTheme = !isDarkTheme },
                        icon = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = "Toggle theme"
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                // Content
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {
                    when (selectedTab) {
                        0 -> SoulSyncShowcaseScreen()
                        1 -> ComponentsShowcaseScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun SoulSyncShowcaseScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HeadlineLarge(text = "SoulSync Components")
        Spacer(modifier = Modifier.height(24.dp))

        // Temperature Gauge Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleLarge(text = "Temperature Gauge")
                Spacer(modifier = Modifier.height(16.dp))

                var temperature by remember { mutableIntStateOf(72) }
                TemperatureGauge(temperature = temperature)

                Spacer(modifier = Modifier.height(16.dp))

                androidx.compose.material3.Slider(
                    value = temperature.toFloat(),
                    onValueChange = { temperature = it.toInt() },
                    valueRange = 0f..100f,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    CompactTemperatureGauge(temperature = 20)
                    CompactTemperatureGauge(temperature = 50)
                    CompactTemperatureGauge(temperature = 75)
                    CompactTemperatureGauge(temperature = 95)
                }
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                TitleLarge(text = "Streak Counter")
                Spacer(modifier = Modifier.height(16.dp))

                StreakCounter(days = 34, partnerName = "Maria")

                Spacer(modifier = Modifier.height(16.dp))

                StreakCounterCard(
                    days = 34,
                    partnerName = "Maria",
                    subtitle = "Keep it going!"
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Emoji Selectors Section
        TitleLarge(text = "Emoji & Mood Selectors")
        Spacer(modifier = Modifier.height(16.dp))

        var selectedEmoji by remember { mutableIntStateOf(5) }
        var selectedMood by remember { mutableIntStateOf(3) }

        DesdyCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                LabelLarge(text = "Emoji Selector (1-10)")
                Spacer(modifier = Modifier.height(8.dp))
                EmojiSelector(
                    selectedValue = selectedEmoji,
                    onValueSelected = { selectedEmoji = it },
                    showLabels = true
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        DesdyCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                LabelLarge(text = "Mood Selector (1-5)")
                Spacer(modifier = Modifier.height(8.dp))
                MoodSelector(
                    selectedValue = selectedMood,
                    onValueSelected = { selectedMood = it }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Cards Section
        TitleLarge(text = "Check-In & Insight Cards")
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CheckInCard(
                emoji = "\uD83D\uDCAD",
                question = "How are you feeling today?",
                hint = "Rate your mood from 1 to 5",
                modifier = Modifier.weight(1f)
            ) {
                MoodSelector(
                    selectedValue = selectedMood,
                    onValueSelected = { selectedMood = it }
                )
            }

            InsightCard(
                emoji = "\uD83D\uDCA1",
                title = "Time for a date night!",
                description = "It's been 2 weeks since your last quality time together.",
                primaryAction = "Plan a date",
                secondaryAction = "Maybe later",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Progress Section
        TitleLarge(text = "Step Progress")
        Spacer(modifier = Modifier.height(16.dp))

        var currentStep by remember { mutableIntStateOf(3) }

        DesdyCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                StepProgressBar(
                    currentStep = currentStep,
                    totalSteps = 5,
                    showLabels = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                DotProgressBar(
                    currentStep = currentStep,
                    totalSteps = 5
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    DesdyTextButton(
                        text = "Previous",
                        onClick = { if (currentStep > 1) currentStep-- }
                    )
                    DesdyButton(
                        text = "Next",
                        onClick = { if (currentStep < 5) currentStep++ }
                    )
                }
            }
        }
    }
}

@Composable
fun ComponentsShowcaseScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HeadlineLarge(text = "Desdy Components")
        Spacer(modifier = Modifier.height(24.dp))

        // Buttons Section
        TitleLarge(text = "Buttons")
        Spacer(modifier = Modifier.height(16.dp))

        DesdyCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DesdyButton(text = "Primary", onClick = {})
                    DesdyTonalButton(text = "Tonal", onClick = {})
                    DesdyOutlinedButton(text = "Outlined", onClick = {})
                    DesdyTextButton(text = "Text", onClick = {})
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DesdyButton(text = "Disabled", onClick = {}, enabled = false)
                    DesdyTonalButton(text = "Disabled", onClick = {}, enabled = false)
                    DesdyOutlinedButton(text = "Disabled", onClick = {}, enabled = false)
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Typography Section
        TitleLarge(text = "Typography")
        Spacer(modifier = Modifier.height(16.dp))

        DesdyCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                HeadlineLarge(text = "Headline Large")
                HeadlineMedium(text = "Headline Medium")
                TitleLarge(text = "Title Large")
                BodyLarge(text = "Body Large - Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                LabelLarge(text = "Label Large")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Cards Section
        TitleLarge(text = "Cards")
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DesdyCard(modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TitleLarge(text = "Filled Card")
                    Spacer(modifier = Modifier.height(8.dp))
                    BodyLarge(text = "This is a filled card with default styling.")
                }
            }

            com.desdy.components.card.DesdyElevatedCard(modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TitleLarge(text = "Elevated Card")
                    Spacer(modifier = Modifier.height(8.dp))
                    BodyLarge(text = "This card has elevation for depth.")
                }
            }

            com.desdy.components.card.DesdyOutlinedCard(modifier = Modifier.weight(1f)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TitleLarge(text = "Outlined Card")
                    Spacer(modifier = Modifier.height(8.dp))
                    BodyLarge(text = "This card has an outline border.")
                }
            }
        }
    }
}

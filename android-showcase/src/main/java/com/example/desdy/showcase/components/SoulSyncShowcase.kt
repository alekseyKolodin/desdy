package com.example.desdy.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.desdy.components.card.CheckInCard
import com.desdy.components.card.CompactCheckInCard
import com.desdy.components.card.CompactInsightCard
import com.desdy.components.card.InsightCard
import com.desdy.components.card.TipCard
import com.desdy.components.counter.StreakCounter
import com.desdy.components.counter.StreakCounterCard
import com.desdy.components.counter.StreakBadge
import com.desdy.components.gauge.CompactTemperatureGauge
import com.desdy.components.gauge.TemperatureGauge
import com.desdy.components.progress.DotProgressBar
import com.desdy.components.progress.LabeledStepProgressBar
import com.desdy.components.progress.LinearStepProgress
import com.desdy.components.progress.StepProgressBar
import com.desdy.components.selector.EmojiSelector
import com.desdy.components.selector.MoodSelector
import com.desdy.components.text.LabelLarge
import com.desdy.theme.DesdyTheme

/**
 * Showcase for SoulSync-specific components.
 */
@Composable
fun SoulSyncShowcase() {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large)
    ) {
        // Temperature Gauge Section
        LabelLarge(text = "Temperature Gauge")
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            var temperature by remember { mutableIntStateOf(72) }

            TemperatureGauge(temperature = temperature)

            Spacer(modifier = Modifier.height(8.dp))

            // Slider to change temperature
            androidx.compose.material3.Slider(
                value = temperature.toFloat(),
                onValueChange = { temperature = it.toInt() },
                valueRange = 0f..100f,
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Compact versions
            LabelLarge(text = "Compact Temperature Gauges")
            androidx.compose.foundation.layout.Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                CompactTemperatureGauge(temperature = 20)
                CompactTemperatureGauge(temperature = 50)
                CompactTemperatureGauge(temperature = 75)
                CompactTemperatureGauge(temperature = 95)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Emoji Selector Section
        LabelLarge(text = "Emoji Selector (1-10)")
        var selectedEmoji by remember { mutableIntStateOf(5) }
        EmojiSelector(
            selectedValue = selectedEmoji,
            onValueSelected = { selectedEmoji = it },
            showLabels = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mood Selector Section
        LabelLarge(text = "Mood Selector (1-5)")
        var selectedMood by remember { mutableIntStateOf(3) }
        MoodSelector(
            selectedValue = selectedMood,
            onValueSelected = { selectedMood = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Check-In Card Section
        LabelLarge(text = "Check-In Card")
        CheckInCard(
            emoji = "\uD83D\uDCAD", // 💭
            question = "How are you feeling today?",
            hint = "Rate your mood from 1 to 5"
        ) {
            MoodSelector(
                selectedValue = selectedMood,
                onValueSelected = { selectedMood = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        CompactCheckInCard(
            emoji = "\u2764\uFE0F", // ❤️
            question = "Did you say 'I love you' today?"
        ) {
            androidx.compose.foundation.layout.Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                com.desdy.components.button.DesdyButton(
                    text = "Yes",
                    onClick = {}
                )
                com.desdy.components.button.DesdyOutlinedButton(
                    text = "Not yet",
                    onClick = {}
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Insight Card Section
        LabelLarge(text = "Insight Card")
        InsightCard(
            emoji = "\uD83D\uDCA1", // 💡
            title = "Time for a date night!",
            description = "It's been 2 weeks since your last quality time together. Planning a special evening could boost your relationship temperature.",
            primaryAction = "Plan a date",
            secondaryAction = "Maybe later",
            onPrimaryClick = {},
            onSecondaryClick = {}
        )

        Spacer(modifier = Modifier.height(8.dp))

        CompactInsightCard(
            emoji = "\uD83C\uDF1F", // 🌟
            title = "Great communication streak!",
            description = "You've shared feelings 5 days in a row.",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(8.dp))

        TipCard(
            emoji = "\uD83D\uDCA1", // 💡
            tip = "Try asking about your partner's day before sharing your own."
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Streak Counter Section
        LabelLarge(text = "Streak Counter")
        StreakCounter(
            days = 34,
            partnerName = "Maria"
        )

        Spacer(modifier = Modifier.height(8.dp))

        StreakCounterCard(
            days = 34,
            partnerName = "Maria",
            subtitle = "Keep it going!"
        )

        Spacer(modifier = Modifier.height(8.dp))

        androidx.compose.foundation.layout.Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LabelLarge(text = "Streak Badge:")
            StreakBadge(days = 34)
            StreakBadge(days = 7, size = 48.dp)
            StreakBadge(days = 100, size = 56.dp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Step Progress Bar Section
        LabelLarge(text = "Step Progress Bar")
        var currentStep by remember { mutableIntStateOf(3) }

        StepProgressBar(
            currentStep = currentStep,
            totalSteps = 5,
            showLabels = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Buttons to change step
        androidx.compose.foundation.layout.Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            com.desdy.components.button.DesdyTextButton(
                text = "Previous",
                onClick = { if (currentStep > 1) currentStep-- }
            )
            com.desdy.components.button.DesdyButton(
                text = "Next",
                onClick = { if (currentStep < 5) currentStep++ }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LabelLarge(text = "Dot Progress Bar")
        DotProgressBar(
            currentStep = currentStep,
            totalSteps = 5
        )

        Spacer(modifier = Modifier.height(16.dp))

        LabelLarge(text = "Linear Step Progress")
        LinearStepProgress(
            currentStep = currentStep,
            totalSteps = 5,
            showPercentage = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        LabelLarge(text = "Labeled Step Progress")
        LabeledStepProgressBar(
            currentStep = currentStep,
            stepLabels = listOf("Mood", "Day", "Love", "Talk", "Done")
        )
    }
}

package com.desdy.components.selector

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desdy.theme.DesdyTheme

/**
 * Emoji options for the 1-10 scale selector.
 */
object EmojiSelectorDefaults {
    /**
     * Default emojis for 1-10 scale.
     */
    val defaultEmojis = listOf(
        "\uD83D\uDE22", // 😢 1 - Crying
        "\uD83D\uDE1E", // 😞 2 - Disappointed
        "\uD83D\uDE14", // 😔 3 - Pensive
        "\uD83D\uDE11", // 😑 4 - Expressionless
        "\uD83D\uDE10", // 😐 5 - Neutral
        "\uD83D\uDE42", // 🙂 6 - Slightly smiling
        "\uD83D\uDE0A", // 😊 7 - Smiling
        "\uD83D\uDE04", // 😄 8 - Grinning
        "\uD83D\uDE03", // 😃 9 - Big smile
        "\uD83D\uDE0D"  // 😍 10 - Heart eyes
    )

    /**
     * Get emoji for a value (1-10).
     */
    fun getEmojiForValue(value: Int): String {
        val index = (value - 1).coerceIn(0, defaultEmojis.lastIndex)
        return defaultEmojis[index]
    }
}

/**
 * Emoji selector for 1-10 scale.
 *
 * Horizontal picker with emoji indicators representing feelings/mood.
 *
 * @param selectedValue Currently selected value (1-10).
 * @param onValueSelected Called when a value is selected.
 * @param modifier Modifier for the selector.
 * @param emojis List of 10 emojis to display.
 * @param emojiSize Size of each emoji.
 * @param showLabels Whether to show numeric labels below emojis.
 * @param enabled Whether selection is enabled.
 * @param animated Whether to animate selection changes.
 */
@Composable
fun EmojiSelector(
    selectedValue: Int,
    onValueSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    emojis: List<String> = EmojiSelectorDefaults.defaultEmojis,
    emojiSize: Dp = 32.dp,
    showLabels: Boolean = false,
    enabled: Boolean = true,
    animated: Boolean = true
) {
    require(emojis.size == 10) { "EmojiSelector requires exactly 10 emojis" }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        emojis.forEachIndexed { index, emoji ->
            val value = index + 1
            val isSelected = value == selectedValue

            EmojiItem(
                emoji = emoji,
                value = value,
                isSelected = isSelected,
                onClick = { if (enabled) onValueSelected(value) },
                emojiSize = emojiSize,
                showLabel = showLabels,
                enabled = enabled,
                animated = animated
            )
        }
    }
}

/**
 * Individual emoji item in the selector.
 */
@Composable
private fun EmojiItem(
    emoji: String,
    value: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    emojiSize: Dp,
    showLabel: Boolean,
    enabled: Boolean,
    animated: Boolean
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.2f else 1f,
        animationSpec = tween(durationMillis = if (animated) 200 else 0),
        label = "emoji_scale"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) {
            DesdyTheme.colors.primary.copy(alpha = 0.2f)
        } else {
            Color.Transparent
        },
        animationSpec = tween(durationMillis = if (animated) 200 else 0),
        label = "emoji_background"
    )

    val borderColor by animateColorAsState(
        targetValue = if (isSelected) {
            DesdyTheme.colors.primary
        } else {
            Color.Transparent
        },
        animationSpec = tween(durationMillis = if (animated) 200 else 0),
        label = "emoji_border"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(CircleShape)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(emojiSize + 8.dp)
                .scale(scale)
                .background(backgroundColor, CircleShape)
                .border(
                    width = if (isSelected) 2.dp else 0.dp,
                    color = borderColor,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = emoji,
                fontSize = (emojiSize.value * 0.7f).sp,
                modifier = Modifier.padding(4.dp)
            )
        }

        if (showLabel) {
            Text(
                text = value.toString(),
                style = DesdyTheme.typography.labelSmall,
                color = if (isSelected) {
                    DesdyTheme.colors.primary
                } else {
                    DesdyTheme.colors.onSurfaceVariant
                },
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

/**
 * Compact emoji selector showing only 5 emojis.
 *
 * Simplified version with 5 options for quick mood selection.
 *
 * @param selectedValue Currently selected value (1-5).
 * @param onValueSelected Called when a value is selected.
 * @param modifier Modifier for the selector.
 * @param emojiSize Size of each emoji.
 * @param enabled Whether selection is enabled.
 */
@Composable
fun MoodSelector(
    selectedValue: Int,
    onValueSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    emojiSize: Dp = 40.dp,
    enabled: Boolean = true
) {
    val moods = listOf(
        "\uD83D\uDE22", // 😢 1 - Very sad
        "\uD83D\uDE1E", // 😞 2 - Sad
        "\uD83D\uDE10", // 😐 3 - Neutral
        "\uD83D\uDE0A", // 😊 4 - Happy
        "\uD83D\uDE0D"  // 😍 5 - Very happy
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        moods.forEachIndexed { index, emoji ->
            val value = index + 1
            val isSelected = value == selectedValue

            MoodItem(
                emoji = emoji,
                isSelected = isSelected,
                onClick = { if (enabled) onValueSelected(value) },
                emojiSize = emojiSize,
                enabled = enabled
            )
        }
    }
}

/**
 * Individual mood item in the compact selector.
 */
@Composable
private fun MoodItem(
    emoji: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    emojiSize: Dp,
    enabled: Boolean
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.3f else 1f,
        animationSpec = tween(durationMillis = 200),
        label = "mood_scale"
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) {
            DesdyTheme.colors.primary.copy(alpha = 0.15f)
        } else {
            Color.Transparent
        },
        animationSpec = tween(durationMillis = 200),
        label = "mood_background"
    )

    Box(
        modifier = Modifier
            .size(emojiSize + 16.dp)
            .scale(scale)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = emoji,
            fontSize = (emojiSize.value * 0.8f).sp
        )
    }
}

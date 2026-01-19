package com.desdy.components.counter

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desdy.components.card.DesdyCard
import com.desdy.theme.DesdyTheme

/**
 * SoulSync Streak Counter.
 *
 * Displays the number of consecutive days with a partner.
 *
 * @param days Number of streak days.
 * @param partnerName Partner's name to display.
 * @param modifier Modifier for the counter.
 * @param emoji Streak emoji (fire by default).
 * @param animated Whether to animate count changes.
 */
@Composable
fun StreakCounter(
    days: Int,
    partnerName: String,
    modifier: Modifier = Modifier,
    emoji: String = "\uD83D\uDD25", // 🔥
    animated: Boolean = true
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = emoji,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.width(8.dp))

        if (animated) {
            AnimatedContent(
                targetState = days,
                transitionSpec = {
                    (slideInVertically { -it } + fadeIn(tween(300)))
                        .togetherWith(slideOutVertically { it } + fadeOut(tween(300)))
                },
                label = "streak_animation"
            ) { targetDays ->
                StreakText(days = targetDays, partnerName = partnerName)
            }
        } else {
            StreakText(days = days, partnerName = partnerName)
        }
    }
}

@Composable
private fun StreakText(days: Int, partnerName: String) {
    Text(
        text = buildAnnotatedString {
            append("You & ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append(partnerName)
            }
            append(": ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = DesdyTheme.colors.primary)) {
                append("$days")
            }
            append(if (days == 1) " day" else " days")
        },
        style = DesdyTheme.typography.bodyLarge,
        color = DesdyTheme.colors.onSurface
    )
}

/**
 * Streak Counter Card.
 *
 * Streak counter wrapped in a card with additional info.
 *
 * @param days Number of streak days.
 * @param partnerName Partner's name.
 * @param modifier Modifier for the card.
 * @param subtitle Optional subtitle text.
 * @param accentColor Accent color for highlights.
 */
@Composable
fun StreakCounterCard(
    days: Int,
    partnerName: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    accentColor: Color = DesdyTheme.colors.primary
) {
    DesdyCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Fire emoji with accent background
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "\uD83D\uDD25", // 🔥
                    fontSize = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Days count
            Text(
                text = "$days",
                style = DesdyTheme.typography.displayMedium,
                color = accentColor,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = if (days == 1) "day" else "days",
                style = DesdyTheme.typography.titleMedium,
                color = DesdyTheme.colors.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Partner info
            Text(
                text = "with $partnerName",
                style = DesdyTheme.typography.bodyMedium,
                color = DesdyTheme.colors.onSurface
            )

            if (subtitle != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    style = DesdyTheme.typography.bodySmall,
                    color = DesdyTheme.colors.onSurfaceVariant
                )
            }
        }
    }
}

/**
 * Compact Streak Badge.
 *
 * Small badge showing streak count.
 *
 * @param days Number of streak days.
 * @param modifier Modifier for the badge.
 * @param size Badge size.
 */
@Composable
fun StreakBadge(
    days: Int,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(DesdyTheme.colors.primary.copy(alpha = 0.15f)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "\uD83D\uDD25", // 🔥
                fontSize = (size.value * 0.4f).sp
            )
            Text(
                text = "$days",
                style = DesdyTheme.typography.labelSmall,
                color = DesdyTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/**
 * Milestone Streak Display.
 *
 * Special display for milestone achievements (7, 30, 100 days, etc.).
 *
 * @param days Number of days.
 * @param partnerName Partner's name.
 * @param modifier Modifier for the display.
 * @param milestone Milestone being celebrated.
 * @param message Celebration message.
 */
@Composable
fun StreakMilestone(
    days: Int,
    partnerName: String,
    modifier: Modifier = Modifier,
    milestone: Int = days,
    message: String = "Amazing streak!"
) {
    DesdyCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Celebration emoji
            Text(
                text = "\uD83C\uDF89", // 🎉
                fontSize = 48.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Milestone number
            Text(
                text = "$milestone",
                style = DesdyTheme.typography.displayLarge,
                color = DesdyTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "day streak!",
                style = DesdyTheme.typography.headlineSmall,
                color = DesdyTheme.colors.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Message
            Text(
                text = message,
                style = DesdyTheme.typography.bodyMedium,
                color = DesdyTheme.colors.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "You & $partnerName \u2764\uFE0F", // ❤️
                style = DesdyTheme.typography.bodyMedium,
                color = DesdyTheme.colors.onSurface
            )
        }
    }
}

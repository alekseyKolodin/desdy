package com.desdy.components.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desdy.theme.DesdyTheme

/**
 * SoulSync Check-In Card.
 *
 * A card for displaying check-in questions with emoji, question text,
 * optional hint, and content slot for input controls.
 *
 * @param emoji Emoji to display at the top.
 * @param question Main question text.
 * @param modifier Modifier for the card.
 * @param hint Optional hint text below the question.
 * @param content Content slot for input controls (e.g., EmojiSelector, TextField).
 */
@Composable
fun CheckInCard(
    emoji: String,
    question: String,
    modifier: Modifier = Modifier,
    hint: String? = null,
    content: @Composable () -> Unit
) {
    DesdyCard(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Emoji
            Text(
                text = emoji,
                fontSize = 48.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Question
            Text(
                text = question,
                style = DesdyTheme.typography.headlineSmall,
                color = DesdyTheme.colors.onSurface,
                textAlign = TextAlign.Center
            )

            // Hint
            if (hint != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = hint,
                    style = DesdyTheme.typography.bodySmall,
                    color = DesdyTheme.colors.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Content slot
            content()
        }
    }
}

/**
 * Compact Check-In Card variant.
 *
 * Smaller version for lists or secondary questions.
 */
@Composable
fun CompactCheckInCard(
    emoji: String,
    question: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    DesdyCard(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Emoji
            Text(
                text = emoji,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Question
            Text(
                text = question,
                style = DesdyTheme.typography.titleMedium,
                color = DesdyTheme.colors.onSurface,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Content slot
            content()
        }
    }
}

/**
 * Check-In Card with horizontal layout.
 *
 * Emoji on the left, question and content on the right.
 */
@Composable
fun HorizontalCheckInCard(
    emoji: String,
    question: String,
    modifier: Modifier = Modifier,
    hint: String? = null,
    content: @Composable () -> Unit
) {
    DesdyCard(
        modifier = modifier.fillMaxWidth()
    ) {
        androidx.compose.foundation.layout.Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Emoji on the left
            Text(
                text = emoji,
                fontSize = 40.sp,
                modifier = Modifier.padding(end = 16.dp)
            )

            // Question and content on the right
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = question,
                    style = DesdyTheme.typography.titleMedium,
                    color = DesdyTheme.colors.onSurface
                )

                if (hint != null) {
                    Text(
                        text = hint,
                        style = DesdyTheme.typography.bodySmall,
                        color = DesdyTheme.colors.onSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                content()
            }
        }
    }
}

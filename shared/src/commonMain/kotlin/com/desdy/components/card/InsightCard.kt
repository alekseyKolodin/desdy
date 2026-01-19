package com.desdy.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.desdy.components.button.DesdyButton
import com.desdy.components.button.DesdyTextButton
import com.desdy.theme.DesdyTheme

/**
 * SoulSync Insight Card.
 *
 * Card for displaying AI-generated recommendations with call-to-action buttons.
 *
 * @param emoji Emoji representing the insight type.
 * @param title Insight title.
 * @param description Insight description/recommendation text.
 * @param modifier Modifier for the card.
 * @param primaryAction Primary CTA button text (e.g., "Let's try it!").
 * @param secondaryAction Secondary CTA button text (e.g., "Not now").
 * @param onPrimaryClick Called when primary button is clicked.
 * @param onSecondaryClick Called when secondary button is clicked.
 * @param accentColor Optional accent color for the card.
 */
@Composable
fun InsightCard(
    emoji: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    primaryAction: String = "Let's try it!",
    secondaryAction: String = "Not now",
    onPrimaryClick: () -> Unit = {},
    onSecondaryClick: () -> Unit = {},
    accentColor: Color = DesdyTheme.colors.primary
) {
    DesdyCard(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Header with emoji and sparkle indicator
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Emoji with accent background
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(accentColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = emoji,
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // AI indicator
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "\u2728", // ✨ Sparkles
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "AI Insight",
                        style = DesdyTheme.typography.labelSmall,
                        color = accentColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Text(
                text = title,
                style = DesdyTheme.typography.titleLarge,
                color = DesdyTheme.colors.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = description,
                style = DesdyTheme.typography.bodyMedium,
                color = DesdyTheme.colors.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Action buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                DesdyTextButton(
                    text = secondaryAction,
                    onClick = onSecondaryClick,
                    modifier = Modifier.weight(1f)
                )

                DesdyButton(
                    text = primaryAction,
                    onClick = onPrimaryClick,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

/**
 * Compact Insight Card.
 *
 * Smaller version without action buttons, suitable for lists.
 */
@Composable
fun CompactInsightCard(
    emoji: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    accentColor: Color = DesdyTheme.colors.primary
) {
    DesdyCard(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Emoji with accent background
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = emoji,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                // AI indicator
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "\u2728", // ✨ Sparkles
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "AI Insight",
                        style = DesdyTheme.typography.labelSmall,
                        color = accentColor
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Title
                Text(
                    text = title,
                    style = DesdyTheme.typography.titleSmall,
                    color = DesdyTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Description
                Text(
                    text = description,
                    style = DesdyTheme.typography.bodySmall,
                    color = DesdyTheme.colors.onSurfaceVariant,
                    maxLines = 2
                )
            }
        }
    }
}

/**
 * Insight Card for tips/suggestions.
 *
 * Simpler card for general tips without strong CTA.
 */
@Composable
fun TipCard(
    emoji: String,
    tip: String,
    modifier: Modifier = Modifier,
    accentColor: Color = DesdyTheme.colors.secondary
) {
    DesdyCard(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Emoji
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(accentColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = emoji,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Tip text
            Text(
                text = tip,
                style = DesdyTheme.typography.bodyMedium,
                color = DesdyTheme.colors.onSurface,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

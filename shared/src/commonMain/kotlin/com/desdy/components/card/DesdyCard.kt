package com.desdy.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.desdy.foundation.elevation.DesdyElevationTokens
import com.desdy.theme.DesdyTheme

/**
 * Desdy filled card.
 *
 * Use for containing related content.
 *
 * @param modifier Modifier for the card.
 * @param onClick Optional click handler. If null, card is not clickable.
 * @param enabled Whether the card is enabled (for clickable cards).
 * @param shape Card shape.
 * @param containerColor Background color.
 * @param contentColor Content color.
 * @param content Card content.
 */
@Composable
fun DesdyCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    shape: Shape = DesdyTheme.shapes.medium,
    containerColor: Color = DesdyTheme.colors.surface,
    contentColor: Color = DesdyTheme.colors.onSurface,
    content: @Composable ColumnScope.() -> Unit
) {
    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            shape = shape,
            colors = CardDefaults.cardColors(
                containerColor = containerColor,
                contentColor = contentColor,
                disabledContainerColor = DesdyTheme.colors.surfaceVariant,
                disabledContentColor = DesdyTheme.colors.onSurfaceVariant
            ),
            content = content
        )
    } else {
        Card(
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.cardColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            content = content
        )
    }
}

/**
 * Desdy elevated card.
 *
 * Use for cards that need visual lift from the surface.
 */
@Composable
fun DesdyElevatedCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    shape: Shape = DesdyTheme.shapes.medium,
    containerColor: Color = DesdyTheme.colors.surface,
    contentColor: Color = DesdyTheme.colors.onSurface,
    elevation: CardElevation = CardDefaults.elevatedCardElevation(
        defaultElevation = DesdyElevationTokens.CardElevated
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    if (onClick != null) {
        ElevatedCard(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            shape = shape,
            colors = CardDefaults.elevatedCardColors(
                containerColor = containerColor,
                contentColor = contentColor,
                disabledContainerColor = DesdyTheme.colors.surfaceVariant,
                disabledContentColor = DesdyTheme.colors.onSurfaceVariant
            ),
            elevation = elevation,
            content = content
        )
    } else {
        ElevatedCard(
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.elevatedCardColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            elevation = elevation,
            content = content
        )
    }
}

/**
 * Desdy outlined card.
 *
 * Use for cards with border outline.
 */
@Composable
fun DesdyOutlinedCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    shape: Shape = DesdyTheme.shapes.medium,
    containerColor: Color = DesdyTheme.colors.surface,
    contentColor: Color = DesdyTheme.colors.onSurface,
    border: BorderStroke = BorderStroke(1.dp, DesdyTheme.colors.outlineVariant),
    content: @Composable ColumnScope.() -> Unit
) {
    if (onClick != null) {
        OutlinedCard(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            shape = shape,
            colors = CardDefaults.outlinedCardColors(
                containerColor = containerColor,
                contentColor = contentColor,
                disabledContainerColor = DesdyTheme.colors.surfaceVariant,
                disabledContentColor = DesdyTheme.colors.onSurfaceVariant
            ),
            border = border,
            content = content
        )
    } else {
        OutlinedCard(
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.outlinedCardColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            border = border,
            content = content
        )
    }
}

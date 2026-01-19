package com.desdy.components.list

import androidx.compose.foundation.clickable
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.desdy.theme.DesdyTheme

/**
 * Default colors for Desdy list items.
 */
object DesdyListItemDefaults {
    @Composable
    fun colors(): ListItemColors = ListItemDefaults.colors(
        containerColor = DesdyTheme.colors.surface,
        headlineColor = DesdyTheme.colors.onSurface,
        supportingColor = DesdyTheme.colors.onSurfaceVariant,
        overlineColor = DesdyTheme.colors.onSurfaceVariant,
        leadingIconColor = DesdyTheme.colors.onSurfaceVariant,
        trailingIconColor = DesdyTheme.colors.onSurfaceVariant,
        disabledHeadlineColor = DesdyTheme.colors.onDisabled,
        disabledLeadingIconColor = DesdyTheme.colors.onDisabled,
        disabledTrailingIconColor = DesdyTheme.colors.onDisabled
    )
}

/**
 * Desdy list item.
 *
 * @param headlineContent Primary text/content.
 * @param modifier Modifier for the list item.
 * @param overlineContent Optional overline text (above headline).
 * @param supportingContent Optional supporting text (below headline).
 * @param leadingContent Optional leading content (icon, avatar, image).
 * @param trailingContent Optional trailing content (icon, text, control).
 * @param colors List item colors.
 */
@Composable
fun DesdyListItem(
    headlineContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    overlineContent: @Composable (() -> Unit)? = null,
    supportingContent: @Composable (() -> Unit)? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    colors: ListItemColors = DesdyListItemDefaults.colors()
) {
    ListItem(
        headlineContent = headlineContent,
        modifier = modifier,
        overlineContent = overlineContent,
        supportingContent = supportingContent,
        leadingContent = leadingContent,
        trailingContent = trailingContent,
        colors = colors
    )
}

/**
 * Desdy clickable list item.
 *
 * List item with click handling.
 */
@Composable
fun DesdyClickableListItem(
    headlineContent: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    overlineContent: @Composable (() -> Unit)? = null,
    supportingContent: @Composable (() -> Unit)? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    colors: ListItemColors = DesdyListItemDefaults.colors()
) {
    ListItem(
        headlineContent = headlineContent,
        modifier = modifier.clickable(enabled = enabled, onClick = onClick),
        overlineContent = overlineContent,
        supportingContent = supportingContent,
        leadingContent = leadingContent,
        trailingContent = trailingContent,
        colors = colors
    )
}

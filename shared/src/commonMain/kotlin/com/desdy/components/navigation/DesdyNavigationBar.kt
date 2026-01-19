package com.desdy.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.desdy.theme.DesdyTheme

/**
 * Desdy navigation bar (bottom navigation).
 *
 * @param modifier Modifier for the navigation bar.
 * @param containerColor Background color.
 * @param contentColor Content color.
 * @param content Navigation bar items.
 */
@Composable
fun DesdyNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = DesdyTheme.colors.surface,
    contentColor: Color = DesdyTheme.colors.onSurface,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        content = content
    )
}

/**
 * Desdy navigation bar item.
 *
 * @param selected Whether the item is selected.
 * @param onClick Called when item is clicked.
 * @param icon Icon composable.
 * @param modifier Modifier for the item.
 * @param enabled Whether the item is enabled.
 * @param label Optional label composable.
 * @param alwaysShowLabel Whether to always show label (even when not selected).
 */
@Composable
fun RowScope.DesdyNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = DesdyTheme.colors.onSecondaryContainer,
            selectedTextColor = DesdyTheme.colors.onSurface,
            indicatorColor = DesdyTheme.colors.secondaryContainer,
            unselectedIconColor = DesdyTheme.colors.onSurfaceVariant,
            unselectedTextColor = DesdyTheme.colors.onSurfaceVariant,
            disabledIconColor = DesdyTheme.colors.onDisabled,
            disabledTextColor = DesdyTheme.colors.onDisabled
        )
    )
}

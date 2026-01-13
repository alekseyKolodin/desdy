package com.desdy.components.tabs

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.desdy.theme.DesdyTheme

/**
 * Desdy fixed tab row.
 *
 * @param selectedTabIndex Currently selected tab index.
 * @param modifier Modifier for the tab row.
 * @param containerColor Background color.
 * @param contentColor Content color.
 * @param tabs Tab composables.
 */
@Composable
fun DesdyTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = DesdyTheme.colors.surface,
    contentColor: Color = DesdyTheme.colors.onSurface,
    tabs: @Composable () -> Unit
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = DesdyTheme.colors.primary
                )
            }
        },
        divider = { },
        tabs = tabs
    )
}

/**
 * Desdy scrollable tab row.
 *
 * For more than 4-5 tabs.
 */
@Composable
fun DesdyScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = DesdyTheme.colors.surface,
    contentColor: Color = DesdyTheme.colors.onSurface,
    tabs: @Composable () -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        indicator = { tabPositions ->
            if (selectedTabIndex < tabPositions.size) {
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = DesdyTheme.colors.primary
                )
            }
        },
        divider = { },
        tabs = tabs
    )
}

/**
 * Desdy tab.
 *
 * @param selected Whether the tab is selected.
 * @param onClick Called when tab is clicked.
 * @param modifier Modifier for the tab.
 * @param enabled Whether the tab is enabled.
 * @param text Optional text composable.
 * @param icon Optional icon composable.
 */
@Composable
fun DesdyTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null
) {
    Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        text = text,
        icon = icon,
        selectedContentColor = DesdyTheme.colors.primary,
        unselectedContentColor = DesdyTheme.colors.onSurfaceVariant
    )
}

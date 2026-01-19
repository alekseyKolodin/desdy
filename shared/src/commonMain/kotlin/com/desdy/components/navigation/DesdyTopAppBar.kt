package com.desdy.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.desdy.theme.DesdyTheme

/**
 * Default colors for Desdy top app bars.
 */
@OptIn(ExperimentalMaterial3Api::class)
object DesdyTopAppBarDefaults {
    @Composable
    fun topAppBarColors(): TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = DesdyTheme.colors.surface,
        scrolledContainerColor = DesdyTheme.colors.surfaceContainer,
        navigationIconContentColor = DesdyTheme.colors.onSurface,
        titleContentColor = DesdyTheme.colors.onSurface,
        actionIconContentColor = DesdyTheme.colors.onSurfaceVariant
    )

    @Composable
    fun centerAlignedTopAppBarColors(): TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = DesdyTheme.colors.surface,
        scrolledContainerColor = DesdyTheme.colors.surfaceContainer,
        navigationIconContentColor = DesdyTheme.colors.onSurface,
        titleContentColor = DesdyTheme.colors.onSurface,
        actionIconContentColor = DesdyTheme.colors.onSurfaceVariant
    )

    @Composable
    fun largeTopAppBarColors(): TopAppBarColors = TopAppBarDefaults.largeTopAppBarColors(
        containerColor = DesdyTheme.colors.surface,
        scrolledContainerColor = DesdyTheme.colors.surfaceContainer,
        navigationIconContentColor = DesdyTheme.colors.onSurface,
        titleContentColor = DesdyTheme.colors.onSurface,
        actionIconContentColor = DesdyTheme.colors.onSurfaceVariant
    )
}

/**
 * Desdy top app bar.
 *
 * @param title Title composable.
 * @param modifier Modifier for the app bar.
 * @param navigationIcon Optional navigation icon.
 * @param actions Optional action icons.
 * @param colors App bar colors.
 * @param scrollBehavior Optional scroll behavior.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesdyTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = DesdyTopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

/**
 * Desdy center-aligned top app bar.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesdyCenterAlignedTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = DesdyTopAppBarDefaults.centerAlignedTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    CenterAlignedTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

/**
 * Desdy large top app bar.
 *
 * Collapsing top app bar for detail screens.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesdyLargeTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = DesdyTopAppBarDefaults.largeTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    LargeTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        colors = colors,
        scrollBehavior = scrollBehavior
    )
}

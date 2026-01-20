package com.desdy.components.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Custom color configuration for Desdy top app bars.
 */
@Immutable
data class DesdyTopAppBarColors(
    val containerColor: Color,
    val scrolledContainerColor: Color,
    val navigationIconColor: Color,
    val titleColor: Color,
    val actionIconColor: Color
)

/**
 * Default colors and configurations for Desdy top app bars.
 */
object DesdyTopAppBarDefaults {

    /** Standard height for small top app bar */
    val TopAppBarHeight = 64.dp

    /** Expanded height for large top app bar */
    val LargeTopAppBarExpandedHeight = 152.dp

    /** Collapsed height for large top app bar */
    val LargeTopAppBarCollapsedHeight = 64.dp

    /**
     * Default colors for standard top app bar.
     */
    @Composable
    fun colors(
        containerColor: Color = DesdyTheme.colors.background,
        scrolledContainerColor: Color = DesdyTheme.colors.surfaceContainer,
        navigationIconColor: Color = DesdyTheme.colors.onSurface,
        titleColor: Color = DesdyTheme.colors.onSurface,
        actionIconColor: Color = DesdyTheme.colors.onSurfaceVariant
    ): DesdyTopAppBarColors = DesdyTopAppBarColors(
        containerColor = containerColor,
        scrolledContainerColor = scrolledContainerColor,
        navigationIconColor = navigationIconColor,
        titleColor = titleColor,
        actionIconColor = actionIconColor
    )

    /**
     * Transparent colors for top app bar overlay on content.
     */
    @Composable
    fun transparentColors(
        containerColor: Color = Color.Transparent,
        scrolledContainerColor: Color = DesdyTheme.colors.surfaceContainer.copy(alpha = 0.95f),
        navigationIconColor: Color = DesdyTheme.colors.onSurface,
        titleColor: Color = DesdyTheme.colors.onSurface,
        actionIconColor: Color = DesdyTheme.colors.onSurfaceVariant
    ): DesdyTopAppBarColors = DesdyTopAppBarColors(
        containerColor = containerColor,
        scrolledContainerColor = scrolledContainerColor,
        navigationIconColor = navigationIconColor,
        titleColor = titleColor,
        actionIconColor = actionIconColor
    )

    /**
     * Primary colored top app bar.
     */
    @Composable
    fun primaryColors(
        containerColor: Color = DesdyTheme.colors.primary,
        scrolledContainerColor: Color = DesdyTheme.colors.primary,
        navigationIconColor: Color = DesdyTheme.colors.onPrimary,
        titleColor: Color = DesdyTheme.colors.onPrimary,
        actionIconColor: Color = DesdyTheme.colors.onPrimary
    ): DesdyTopAppBarColors = DesdyTopAppBarColors(
        containerColor = containerColor,
        scrolledContainerColor = scrolledContainerColor,
        navigationIconColor = navigationIconColor,
        titleColor = titleColor,
        actionIconColor = actionIconColor
    )
}

/**
 * Scroll state for top app bar that tracks scroll position.
 */
@Stable
class DesdyTopAppBarScrollState(
    initialScrollOffset: Float = 0f
) {
    var scrollOffset by mutableFloatStateOf(initialScrollOffset)
        internal set

    /**
     * Whether the content has been scrolled.
     */
    val isScrolled: Boolean
        get() = scrollOffset > 0f

    /**
     * Scroll fraction from 0 (not scrolled) to 1 (fully scrolled).
     * Useful for large collapsing top app bar.
     */
    val scrollFraction: Float
        get() = (scrollOffset / 100f).coerceIn(0f, 1f)

    companion object {
        val Saver: Saver<DesdyTopAppBarScrollState, Float> = Saver(
            save = { it.scrollOffset },
            restore = { DesdyTopAppBarScrollState(it) }
        )
    }
}

/**
 * Remember scroll state for top app bar.
 */
@Composable
fun rememberDesdyTopAppBarScrollState(): DesdyTopAppBarScrollState {
    return rememberSaveable(saver = DesdyTopAppBarScrollState.Saver) {
        DesdyTopAppBarScrollState()
    }
}

/**
 * Nested scroll connection for top app bar scroll tracking.
 */
fun DesdyTopAppBarScrollState.nestedScrollConnection(): NestedScrollConnection {
    return object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            val delta = available.y
            val newOffset = (scrollOffset - delta).coerceAtLeast(0f)
            scrollOffset = newOffset
            return Offset.Zero
        }
    }
}

/**
 * Desdy Top App Bar - основной компонент.
 *
 * Полностью кастомный TopAppBar, не зависящий от Material 3.
 * Использует цвета, типографику и отступы из Desdy Design System.
 *
 * @param title Заголовок (composable).
 * @param modifier Модификатор.
 * @param navigationIcon Иконка навигации (например, back arrow).
 * @param actions Action-иконки справа.
 * @param colors Цветовая конфигурация.
 * @param scrollState Состояние скролла для анимации цвета/тени.
 * @param elevation Тень при скролле.
 * @param windowInsets Window insets для status bar.
 */
@Composable
fun DesdyTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: DesdyTopAppBarColors = DesdyTopAppBarDefaults.colors(),
    scrollState: DesdyTopAppBarScrollState? = null,
    elevation: Dp = 0.dp,
    windowInsets: WindowInsets = WindowInsets.statusBars
) {
    val isScrolled = scrollState?.isScrolled ?: false

    val containerColor by animateColorAsState(
        targetValue = if (isScrolled) colors.scrolledContainerColor else colors.containerColor,
        animationSpec = tween(durationMillis = 150, easing = FastOutSlowInEasing),
        label = "containerColor"
    )

    val shadowElevation = if (isScrolled) elevation else 0.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(shadowElevation)
            .background(containerColor)
            .windowInsetsPadding(windowInsets)
            .height(DesdyTopAppBarDefaults.TopAppBarHeight)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(DesdyTopAppBarDefaults.TopAppBarHeight)
                .padding(horizontal = DesdyTheme.spacing.extraSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Navigation icon
            Box(
                modifier = Modifier.padding(start = DesdyTheme.spacing.extraSmall),
                contentAlignment = Alignment.Center
            ) {
                navigationIcon()
            }

            // Title - takes remaining space, aligned to start
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = DesdyTheme.spacing.medium),
                contentAlignment = Alignment.CenterStart
            ) {
                title()
            }

            // Actions
            Row(
                modifier = Modifier.padding(end = DesdyTheme.spacing.extraSmall),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                content = actions
            )
        }
    }
}

/**
 * Desdy Center-Aligned Top App Bar.
 *
 * Вариант с центрированным заголовком.
 *
 * @param title Заголовок (composable).
 * @param modifier Модификатор.
 * @param navigationIcon Иконка навигации.
 * @param actions Action-иконки справа.
 * @param colors Цветовая конфигурация.
 * @param scrollState Состояние скролла.
 * @param elevation Тень при скролле.
 * @param windowInsets Window insets.
 */
@Composable
fun DesdyCenterAlignedTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: DesdyTopAppBarColors = DesdyTopAppBarDefaults.colors(),
    scrollState: DesdyTopAppBarScrollState? = null,
    elevation: Dp = 0.dp,
    windowInsets: WindowInsets = WindowInsets.statusBars
) {
    val isScrolled = scrollState?.isScrolled ?: false

    val containerColor by animateColorAsState(
        targetValue = if (isScrolled) colors.scrolledContainerColor else colors.containerColor,
        animationSpec = tween(durationMillis = 150, easing = FastOutSlowInEasing),
        label = "containerColor"
    )

    val shadowElevation = if (isScrolled) elevation else 0.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(shadowElevation)
            .background(containerColor)
            .windowInsetsPadding(windowInsets)
            .height(DesdyTopAppBarDefaults.TopAppBarHeight)
    ) {
        // Centered title layer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(DesdyTopAppBarDefaults.TopAppBarHeight),
            contentAlignment = Alignment.Center
        ) {
            title()
        }

        // Navigation and actions layer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(DesdyTopAppBarDefaults.TopAppBarHeight)
                .padding(horizontal = DesdyTheme.spacing.extraSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Navigation icon
            Box(
                modifier = Modifier.padding(start = DesdyTheme.spacing.extraSmall),
                contentAlignment = Alignment.Center
            ) {
                navigationIcon()
            }

            // Spacer
            Box(modifier = Modifier.weight(1f))

            // Actions
            Row(
                modifier = Modifier.padding(end = DesdyTheme.spacing.extraSmall),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                content = actions
            )
        }
    }
}

/**
 * Desdy Large Top App Bar.
 *
 * Большой collapsing top app bar для detail-экранов.
 * Заголовок внизу в развёрнутом состоянии.
 *
 * @param title Заголовок (composable).
 * @param modifier Модификатор.
 * @param navigationIcon Иконка навигации.
 * @param actions Action-иконки справа.
 * @param colors Цветовая конфигурация.
 * @param scrollState Состояние скролла для коллапса.
 * @param elevation Тень при скролле.
 * @param windowInsets Window insets.
 */
@Composable
fun DesdyLargeTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: DesdyTopAppBarColors = DesdyTopAppBarDefaults.colors(),
    scrollState: DesdyTopAppBarScrollState? = null,
    elevation: Dp = 0.dp,
    windowInsets: WindowInsets = WindowInsets.statusBars
) {
    val isScrolled = scrollState?.isScrolled ?: false
    val scrollFraction = scrollState?.scrollFraction ?: 0f

    val containerColor by animateColorAsState(
        targetValue = if (isScrolled) colors.scrolledContainerColor else colors.containerColor,
        animationSpec = tween(durationMillis = 150, easing = FastOutSlowInEasing),
        label = "containerColor"
    )

    val shadowElevation = if (isScrolled) elevation else 0.dp

    // Interpolate height based on scroll
    val expandedHeight = DesdyTopAppBarDefaults.LargeTopAppBarExpandedHeight
    val collapsedHeight = DesdyTopAppBarDefaults.LargeTopAppBarCollapsedHeight
    val currentHeight = expandedHeight - ((expandedHeight - collapsedHeight) * scrollFraction)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(shadowElevation)
            .background(containerColor)
            .windowInsetsPadding(windowInsets)
            .height(currentHeight)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Top row with navigation and actions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(collapsedHeight)
                    .padding(horizontal = DesdyTheme.spacing.extraSmall),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Navigation icon
                Box(
                    modifier = Modifier.padding(start = DesdyTheme.spacing.extraSmall),
                    contentAlignment = Alignment.Center
                ) {
                    navigationIcon()
                }

                // Spacer or collapsed title
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = DesdyTheme.spacing.medium),
                    contentAlignment = Alignment.CenterStart
                ) {
                    // Show title in collapsed state
                    if (scrollFraction > 0.5f) {
                        title()
                    }
                }

                // Actions
                Row(
                    modifier = Modifier.padding(end = DesdyTheme.spacing.extraSmall),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    content = actions
                )
            }

            // Expanded title area
            if (scrollFraction < 1f) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(
                            start = DesdyTheme.spacing.medium,
                            end = DesdyTheme.spacing.medium,
                            bottom = DesdyTheme.spacing.large
                        ),
                    contentAlignment = Alignment.BottomStart
                ) {
                    title()
                }
            }
        }
    }
}

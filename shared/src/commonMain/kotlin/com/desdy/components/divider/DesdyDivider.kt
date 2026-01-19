package com.desdy.components.divider

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy horizontal divider.
 *
 * @param modifier Modifier for the divider.
 * @param thickness Thickness of the divider.
 * @param color Divider color.
 */
@Composable
fun DesdyDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = DesdyTheme.colors.divider
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}

/**
 * Desdy vertical divider.
 *
 * @param modifier Modifier for the divider.
 * @param thickness Thickness of the divider.
 * @param color Divider color.
 */
@Composable
fun DesdyVerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = DesdyTheme.colors.divider
) {
    VerticalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}

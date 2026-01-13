package com.desdy.components.snackbar

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.desdy.theme.DesdyTheme

/**
 * Desdy snackbar.
 *
 * @param snackbarData Data for the snackbar.
 * @param modifier Modifier for the snackbar.
 * @param actionOnNewLine Whether action should be on a new line.
 * @param shape Shape of the snackbar.
 * @param containerColor Background color.
 * @param contentColor Content/text color.
 * @param actionColor Action button color.
 * @param dismissActionContentColor Dismiss action color.
 */
@Composable
fun DesdySnackbar(
    snackbarData: SnackbarData,
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
    shape: Shape = DesdyTheme.shapes.small,
    containerColor: Color = DesdyTheme.colors.inverseSurface,
    contentColor: Color = DesdyTheme.colors.inverseOnSurface,
    actionColor: Color = DesdyTheme.colors.inversePrimary,
    actionContentColor: Color = DesdyTheme.colors.inversePrimary,
    dismissActionContentColor: Color = DesdyTheme.colors.inverseOnSurface
) {
    Snackbar(
        snackbarData = snackbarData,
        modifier = modifier,
        actionOnNewLine = actionOnNewLine,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        actionColor = actionColor,
        actionContentColor = actionContentColor,
        dismissActionContentColor = dismissActionContentColor
    )
}

/**
 * Desdy snackbar host.
 *
 * Use with Scaffold for snackbar display.
 *
 * @param hostState State of the snackbar host.
 * @param modifier Modifier for the host.
 * @param snackbar Custom snackbar composable.
 */
@Composable
fun DesdySnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    snackbar: @Composable (SnackbarData) -> Unit = { DesdySnackbar(it) }
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier,
        snackbar = snackbar
    )
}

/**
 * Desdy error snackbar.
 *
 * Snackbar styled for error messages.
 */
@Composable
fun DesdyErrorSnackbar(
    snackbarData: SnackbarData,
    modifier: Modifier = Modifier
) {
    DesdySnackbar(
        snackbarData = snackbarData,
        modifier = modifier,
        containerColor = DesdyTheme.colors.errorContainer,
        contentColor = DesdyTheme.colors.onErrorContainer,
        actionColor = DesdyTheme.colors.error
    )
}

/**
 * Desdy success snackbar.
 *
 * Snackbar styled for success messages.
 */
@Composable
fun DesdySuccessSnackbar(
    snackbarData: SnackbarData,
    modifier: Modifier = Modifier
) {
    DesdySnackbar(
        snackbarData = snackbarData,
        modifier = modifier,
        containerColor = DesdyTheme.colors.successContainer,
        contentColor = DesdyTheme.colors.onSuccessContainer,
        actionColor = DesdyTheme.colors.success
    )
}

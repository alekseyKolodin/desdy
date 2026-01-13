package com.desdy.components.sheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.desdy.theme.DesdyTheme

/**
 * Desdy modal bottom sheet.
 *
 * @param onDismissRequest Called when sheet should be dismissed.
 * @param modifier Modifier for the sheet.
 * @param sheetState State of the sheet.
 * @param shape Shape of the sheet (rounded top corners).
 * @param containerColor Background color.
 * @param contentColor Content color.
 * @param scrimColor Scrim/overlay color.
 * @param dragHandle Optional drag handle composable.
 * @param content Sheet content.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesdyModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    shape: Shape = DesdyTheme.shapes.extraLarge.copy(
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp)
    ),
    containerColor: Color = DesdyTheme.colors.surface,
    contentColor: Color = DesdyTheme.colors.onSurface,
    scrimColor: Color = DesdyTheme.colors.scrim,
    dragHandle: @Composable (() -> Unit)? = { DesdyDragHandle() },
    content: @Composable ColumnScope.() -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        scrimColor = scrimColor,
        dragHandle = dragHandle,
        content = content
    )
}

/**
 * Desdy drag handle for bottom sheets.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesdyDragHandle(
    modifier: Modifier = Modifier,
    color: Color = DesdyTheme.colors.onSurfaceVariant.copy(alpha = 0.4f)
) {
    androidx.compose.material3.BottomSheetDefaults.DragHandle(
        modifier = modifier,
        color = color
    )
}

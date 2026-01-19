package com.desdy.components.text

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.desdy.theme.DesdyTheme

/**
 * Base text component with Desdy typography.
 *
 * @param text The text to display.
 * @param modifier Modifier for the text.
 * @param style Text style from DesdyTypography.
 * @param color Text color. Defaults to LocalContentColor.
 * @param textAlign Text alignment.
 * @param overflow How to handle overflow.
 * @param maxLines Maximum number of lines.
 * @param textDecoration Text decoration (underline, strikethrough).
 */
@Composable
fun DesdyText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = DesdyTheme.typography.bodyMedium,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textDecoration: TextDecoration? = null
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = if (color == Color.Unspecified) LocalContentColor.current else color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        textDecoration = textDecoration
    )
}

// ============================================
// Display Styles
// ============================================

@Composable
fun DisplayLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.displayLarge,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun DisplayMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.displayMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun DisplaySmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.displaySmall,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

// ============================================
// Headline Styles
// ============================================

@Composable
fun HeadlineLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.headlineLarge,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun HeadlineMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.headlineMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun HeadlineSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.headlineSmall,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

// ============================================
// Title Styles
// ============================================

@Composable
fun TitleLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.titleLarge,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun TitleMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.titleMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun TitleSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.titleSmall,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

// ============================================
// Body Styles
// ============================================

@Composable
fun BodyLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.bodyLarge,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun BodyMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.bodyMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun BodySmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.bodySmall,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

// ============================================
// Label Styles
// ============================================

@Composable
fun LabelLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.labelLarge,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun LabelMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.labelMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun LabelSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE
) {
    DesdyText(
        text = text,
        modifier = modifier,
        style = DesdyTheme.typography.labelSmall,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

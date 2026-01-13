package com.example.desdy.showcase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.desdy.components.card.DesdyOutlinedCard
import com.desdy.components.text.BodyLarge
import com.desdy.components.text.BodyMedium
import com.desdy.components.text.BodySmall
import com.desdy.components.text.DisplaySmall
import com.desdy.components.text.HeadlineLarge
import com.desdy.components.text.HeadlineMedium
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.LabelLarge
import com.desdy.components.text.LabelMedium
import com.desdy.components.text.LabelSmall
import com.desdy.components.text.TitleLarge
import com.desdy.components.text.TitleMedium
import com.desdy.components.text.TitleSmall
import com.desdy.theme.DesdyTheme

/**
 * Screen displaying design system foundation: colors, typography, shapes, spacing.
 */
@Composable
fun FoundationScreen() {
    LazyColumn(
        contentPadding = PaddingValues(DesdyTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        item {
            HeadlineMedium(
                text = "Фундамент",
                modifier = Modifier.padding(bottom = DesdyTheme.spacing.small)
            )
        }

        // Colors
        item { ColorsShowcase() }

        // Typography
        item { TypographyShowcase() }

        // Shapes
        item { ShapesShowcase() }

        // Spacing
        item { SpacingShowcase() }
    }
}

@Composable
fun ColorsShowcase() {
    DesdyOutlinedCard {
        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
            TitleMedium(text = "Цвета")
            Spacer(Modifier.height(DesdyTheme.spacing.medium))

            // Primary colors row
            Row(
                horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
            ) {
                ColorSwatch("Primary", DesdyTheme.colors.primary, Color.White)
                ColorSwatch("Secondary", DesdyTheme.colors.secondary, Color.White)
                ColorSwatch("Tertiary", DesdyTheme.colors.tertiary, Color.White)
            }

            Spacer(Modifier.height(DesdyTheme.spacing.medium))

            // Status colors
            LabelMedium(
                text = "Статусы",
                color = DesdyTheme.colors.onSurfaceVariant
            )
            Spacer(Modifier.height(DesdyTheme.spacing.small))
            Row(
                horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
            ) {
                ColorSwatch("Success", DesdyTheme.colors.success, Color.White, size = 48.dp)
                ColorSwatch("Warning", DesdyTheme.colors.warning, Color.White, size = 48.dp)
                ColorSwatch("Error", DesdyTheme.colors.error, Color.White, size = 48.dp)
                ColorSwatch("Info", DesdyTheme.colors.info, Color.White, size = 48.dp)
            }

            Spacer(Modifier.height(DesdyTheme.spacing.medium))

            // Surface colors
            LabelMedium(
                text = "Поверхности",
                color = DesdyTheme.colors.onSurfaceVariant
            )
            Spacer(Modifier.height(DesdyTheme.spacing.small))
            Row(
                horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                ColorSwatch("Background", DesdyTheme.colors.background, DesdyTheme.colors.onBackground, size = 48.dp)
                ColorSwatch("Surface", DesdyTheme.colors.surface, DesdyTheme.colors.onSurface, size = 48.dp)
                ColorSwatch("Variant", DesdyTheme.colors.surfaceVariant, DesdyTheme.colors.onSurfaceVariant, size = 48.dp)
            }
        }
    }
}

@Composable
fun ColorSwatch(
    name: String,
    color: Color,
    textColor: Color,
    size: Dp = 64.dp
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(size)
                .background(color, DesdyTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            // Empty - just showing the color
        }
        Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
        LabelSmall(text = name)
    }
}

@Composable
fun TypographyShowcase() {
    DesdyOutlinedCard {
        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
            TitleMedium(text = "Типографика")
            Spacer(Modifier.height(DesdyTheme.spacing.medium))

            DisplaySmall(text = "Display Small")
            HeadlineLarge(text = "Headline Large")
            HeadlineMedium(text = "Headline Medium")
            HeadlineSmall(text = "Headline Small")
            TitleLarge(text = "Title Large")
            TitleMedium(text = "Title Medium")
            TitleSmall(text = "Title Small")
            BodyLarge(text = "Body Large — для акцентированного текста")
            BodyMedium(text = "Body Medium — основной текст приложения")
            BodySmall(text = "Body Small — вспомогательный текст")
            LabelLarge(text = "LABEL LARGE")
            LabelMedium(text = "LABEL MEDIUM")
            LabelSmall(text = "LABEL SMALL")
        }
    }
}

@Composable
fun ShapesShowcase() {
    DesdyOutlinedCard {
        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
            TitleMedium(text = "Формы")
            Spacer(Modifier.height(DesdyTheme.spacing.medium))

            Row(
                horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                ShapeSample("None", DesdyTheme.shapes.none)
                ShapeSample("XS", DesdyTheme.shapes.extraSmall)
                ShapeSample("S", DesdyTheme.shapes.small)
                ShapeSample("M", DesdyTheme.shapes.medium)
                ShapeSample("L", DesdyTheme.shapes.large)
                ShapeSample("XL", DesdyTheme.shapes.extraLarge)
                ShapeSample("Full", DesdyTheme.shapes.full)
            }
        }
    }
}

@Composable
fun ShapeSample(label: String, shape: Shape) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(DesdyTheme.colors.primaryContainer, shape)
        )
        Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
        LabelSmall(text = label)
    }
}

@Composable
fun SpacingShowcase() {
    DesdyOutlinedCard {
        Column(modifier = Modifier.padding(DesdyTheme.spacing.medium)) {
            TitleMedium(text = "Отступы")
            Spacer(Modifier.height(DesdyTheme.spacing.medium))

            val spacings = listOf(
                "XS (4dp)" to DesdyTheme.spacing.extraSmall,
                "S (8dp)" to DesdyTheme.spacing.small,
                "M (16dp)" to DesdyTheme.spacing.medium,
                "L (24dp)" to DesdyTheme.spacing.large,
                "XL (32dp)" to DesdyTheme.spacing.extraLarge,
            )

            spacings.forEach { (label, space) ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    LabelSmall(
                        text = label,
                        modifier = Modifier.width(80.dp)
                    )
                    Box(
                        modifier = Modifier
                            .width(space)
                            .height(16.dp)
                            .background(DesdyTheme.colors.primary, DesdyTheme.shapes.extraSmall)
                    )
                }
            }
        }
    }
}

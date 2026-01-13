package com.example.desdy.showcase.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.desdy.components.button.DesdyButton
import com.desdy.components.button.DesdyFilledIconButton
import com.desdy.components.button.DesdyFilledTonalIconButton
import com.desdy.components.button.DesdyIconButton
import com.desdy.components.button.DesdyOutlinedButton
import com.desdy.components.button.DesdyOutlinedIconButton
import com.desdy.components.button.DesdyTextButton
import com.desdy.components.button.DesdyTonalButton
import com.desdy.components.text.LabelMedium
import com.desdy.theme.DesdyTheme

/**
 * Showcase for all button variants.
 */
@Composable
fun ButtonsShowcase() {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        // Primary buttons row
        LabelMedium(
            text = "Primary",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdyButton(text = "Enabled", onClick = {})
            DesdyButton(text = "Loading", onClick = {}, loading = true)
            DesdyButton(text = "Disabled", onClick = {}, enabled = false)
            DesdyButton(
                text = "С иконкой",
                onClick = {},
                leadingIcon = Icons.Default.Add
            )
        }

        // Tonal buttons
        LabelMedium(
            text = "Tonal",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdyTonalButton(text = "Tonal", onClick = {})
            DesdyTonalButton(text = "Loading", onClick = {}, loading = true)
            DesdyTonalButton(text = "Disabled", onClick = {}, enabled = false)
        }

        // Outlined buttons
        LabelMedium(
            text = "Outlined",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdyOutlinedButton(text = "Outlined", onClick = {})
            DesdyOutlinedButton(text = "Loading", onClick = {}, loading = true)
            DesdyOutlinedButton(text = "Disabled", onClick = {}, enabled = false)
        }

        // Text buttons
        LabelMedium(
            text = "Text",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            DesdyTextButton(text = "Text", onClick = {})
            DesdyTextButton(text = "Loading", onClick = {}, loading = true)
            DesdyTextButton(text = "Disabled", onClick = {}, enabled = false)
        }

        // Icon buttons
        LabelMedium(
            text = "Icon Buttons",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
        ) {
            DesdyIconButton(icon = Icons.Default.Favorite, onClick = {})
            DesdyFilledIconButton(icon = Icons.Default.Add, onClick = {})
            DesdyFilledTonalIconButton(icon = Icons.Default.Edit, onClick = {})
            DesdyOutlinedIconButton(icon = Icons.Default.Share, onClick = {})
        }
    }
}

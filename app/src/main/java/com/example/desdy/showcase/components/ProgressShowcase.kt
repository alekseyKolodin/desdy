package com.example.desdy.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.desdy.components.progress.DesdyCircularProgressIndicator
import com.desdy.components.progress.DesdyLargeCircularProgress
import com.desdy.components.progress.DesdyLinearProgressIndicator
import com.desdy.components.progress.DesdyMediumCircularProgress
import com.desdy.components.progress.DesdySmallCircularProgress
import com.desdy.components.text.BodySmall
import com.desdy.components.text.LabelMedium
import com.desdy.components.text.LabelSmall
import com.desdy.theme.DesdyTheme

/**
 * Showcase for progress indicators.
 */
@Composable
fun ProgressShowcase() {
    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large)
    ) {
        // Linear Progress
        LabelMedium(
            text = "Linear Progress",
            color = DesdyTheme.colors.onSurfaceVariant
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
        ) {
            BodySmall(text = "Determinate (70%)")
            DesdyLinearProgressIndicator(
                progress = { 0.7f },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(DesdyTheme.spacing.small))

            BodySmall(text = "Indeterminate")
            DesdyLinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }

        // Circular Progress
        LabelMedium(
            text = "Circular Progress",
            color = DesdyTheme.colors.onSurfaceVariant
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DesdySmallCircularProgress()
                Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
                LabelSmall(text = "Small")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DesdyMediumCircularProgress()
                Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
                LabelSmall(text = "Medium")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DesdyLargeCircularProgress()
                Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
                LabelSmall(text = "Large")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                DesdyCircularProgressIndicator(progress = { 0.65f })
                Spacer(Modifier.height(DesdyTheme.spacing.extraSmall))
                LabelSmall(text = "65%")
            }
        }
    }
}

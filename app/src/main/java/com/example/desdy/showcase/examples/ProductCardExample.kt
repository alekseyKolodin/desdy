package com.example.desdy.showcase.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.desdy.components.button.DesdyFilledTonalIconButton
import com.desdy.components.card.DesdyCard
import com.desdy.components.text.BodySmall
import com.desdy.components.text.HeadlineMedium
import com.desdy.components.text.TitleMedium
import com.desdy.theme.DesdyTheme

/**
 * Data class for product.
 */
data class Product(
    val name: String,
    val weight: String,
    val price: Int,
    val oldPrice: Int? = null
)

/**
 * Product card example
 */
@Composable
fun ProductCardExample() {
    val products = listOf(
        Product("Молоко Простоквашино 3.2%", "930 мл", 89, 109),
        Product("Хлеб Бородинский", "400 г", 65),
        Product("Яблоки Гала", "1 кг", 149),
        Product("Сыр Российский", "200 г", 189, 229),
        Product("Йогурт Греческий", "300 г", 79)
    )

    LazyColumn(
        contentPadding = PaddingValues(DesdyTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        item {
            HeadlineMedium(
                text = "Каталог",
                modifier = Modifier.padding(bottom = DesdyTheme.spacing.small)
            )
        }

        items(products) { product ->
            ProductCard(
                name = product.name,
                weight = product.weight,
                price = product.price,
                oldPrice = product.oldPrice
            )
        }
    }
}

@Composable
fun ProductCard(
    name: String,
    weight: String,
    price: Int,
    oldPrice: Int? = null
) {
    DesdyCard(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(DesdyTheme.spacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for image
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        DesdyTheme.colors.surfaceVariant,
                        DesdyTheme.shapes.medium
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Image,
                    contentDescription = null,
                    tint = DesdyTheme.colors.onSurfaceVariant,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(Modifier.width(DesdyTheme.spacing.medium))

            Column(modifier = Modifier.weight(1f)) {
                TitleMedium(text = name, maxLines = 2)
                BodySmall(
                    text = weight,
                    color = DesdyTheme.colors.onSurfaceVariant
                )

                Spacer(Modifier.height(DesdyTheme.spacing.small))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    TitleMedium(
                        text = "$price р.",
                        color = if (oldPrice != null)
                            DesdyTheme.colors.error
                        else
                            DesdyTheme.colors.onSurface
                    )
                    if (oldPrice != null) {
                        Spacer(Modifier.width(DesdyTheme.spacing.small))
                        Text(
                            text = "$oldPrice р.",
                            style = DesdyTheme.typography.bodySmall,
                            color = DesdyTheme.colors.onSurfaceVariant,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }
            }

            DesdyFilledTonalIconButton(
                icon = Icons.Default.Add,
                onClick = {}
            )
        }
    }
}

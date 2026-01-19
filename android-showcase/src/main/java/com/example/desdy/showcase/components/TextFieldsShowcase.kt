package com.example.desdy.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.desdy.components.input.DesdyOutlinedTextField
import com.desdy.components.input.DesdyPasswordField
import com.desdy.components.input.DesdySearchField
import com.desdy.components.input.DesdyTextField
import com.desdy.theme.DesdyTheme

/**
 * Showcase for text field variants.
 */
@Composable
fun TextFieldsShowcase() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var search by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("invalid@") }

    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        DesdyTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = "Filled TextField",
            placeholder = "Введите текст",
            leadingIcon = { Icon(Icons.Default.Person, null) }
        )

        DesdyOutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = "Outlined TextField",
            placeholder = "Введите текст"
        )

        DesdyOutlinedTextField(
            value = errorText,
            onValueChange = { errorText = it },
            label = "С ошибкой",
            isError = true,
            errorMessage = "Некорректный формат email"
        )

        DesdyPasswordField(
            value = password,
            onValueChange = { password = it },
            label = "Пароль"
        )

        DesdySearchField(
            value = search,
            onValueChange = { search = it },
            onSearch = {},
            placeholder = "Поиск..."
        )
    }
}
